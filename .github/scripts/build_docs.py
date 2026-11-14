#!/usr/bin/env python3
"""
Assembla la documentazione Markdown in docs/:
- Cartelle `00-*` (es. 00-cover): legge `<nome>.md` come frontespizio.
- Cartelle `01-*`+ (es. 01-project-plan, ...):
  - Se manca `sections/`, salta la cartella (capitolo non ancora pronto).
  - Se esiste `sections/`, unisce `versioning.md` (se presente) + `sections/NN-*.md`
    e rigenera `XX-nome/<nome>.md`.
- Assembla tutti i blocchi attivi in `docs/project-documentation.md` separati da `---`.
"""

from __future__ import annotations

import argparse
from pathlib import Path
import re
import sys

AUTO_GENERATED_BANNER = "<!-- AUTO-GENERATED FILE: DO NOT EDIT MANUALLY -->"
FOLDER_PATTERN = re.compile(r"^(\d{2})-(.+)$")
SECTION_FILE_PATTERN = re.compile(r"^\d{2}-.*\.md$")


def read_clean(path: Path) -> str:
    return path.read_text(encoding="utf-8-sig").strip()


def render_generated(body: str) -> str:
    return f"{AUTO_GENERATED_BANNER}\n\n{body.strip()}\n"


def format_rel(docs_dir: Path, path: Path) -> str:
    return f"{docs_dir.name}/{path.relative_to(docs_dir).as_posix()}"


def sync_file(path: Path, body: str, dry_run: bool, check_only: bool) -> bool:
    expected = render_generated(body)
    current = path.read_text(encoding="utf-8") if path.exists() else None
    changed = current != expected

    if changed and not dry_run and not check_only:
        path.write_text(expected, encoding="utf-8", newline="\n")

    return changed


def resolve_docs_dir(cli_docs_dir: str | None) -> Path:
    if cli_docs_dir:
        return Path(cli_docs_dir).resolve()

    for parent in Path(__file__).resolve().parents:
        candidate = parent / "docs"
        if candidate.is_dir():
            return candidate

    raise FileNotFoundError(
        "Cartella 'docs/' non trovata nei path genitori. "
        "Specificala manualmente con --docs-dir."
    )


def build_docs(docs_dir: Path, dry_run: bool = False, check_only: bool = False) -> int:
    if not docs_dir.is_dir():
        raise FileNotFoundError(f"Cartella docs non trovata: {docs_dir}")

    macro_folders = sorted(
        (p for p in docs_dir.iterdir() if p.is_dir() and FOLDER_PATTERN.match(p.name)),
        key=lambda p: p.name,
    )
    if not macro_folders:
        raise RuntimeError(f"Nessuna cartella XX-* trovata in {docs_dir}")

    chapters: list[str] = []
    any_out_of_sync = False

    for folder in macro_folders:
        match = FOLDER_PATTERN.match(folder.name)
        assert match is not None
        prefix, slug = match.group(1), match.group(2)

        main_doc_path = folder / f"{slug}.md"
        versioning_path = folder / "versioning.md"
        sections_dir = folder / "sections"

        # Frontespizio / Cover (00-*)
        if prefix == "00":
            if not main_doc_path.is_file():
                raise FileNotFoundError(
                    f"Manca il file del frontespizio '{main_doc_path.name}' in {folder}"
                )
            cover_text = read_clean(main_doc_path)
            if cover_text:
                chapters.append(cover_text)
                print(f"[COVER]          {format_rel(docs_dir, main_doc_path)}")
            else:
                print(f"[SKIP]           {folder.name} (file '{main_doc_path.name}' vuoto)")
            continue

        # Capitoli (01-* e successivi): se manca sections/, salta il capitolo
        if not sections_dir.is_dir():
            print(f"[SKIP]           {folder.name} (cartella 'sections/' assente)")
            continue

        section_files = sorted(
            (p for p in sections_dir.iterdir() if p.is_file() and p.suffix.lower() == ".md"),
            key=lambda p: p.name,
        )
        if not section_files:
            raise RuntimeError(
                f"La cartella '{sections_dir}' esiste ma non contiene alcun file .md"
            )

        for sec in section_files:
            if not SECTION_FILE_PATTERN.match(sec.name):
                raise ValueError(
                    f"Nome file non valido in {sections_dir}: '{sec.name}'. "
                    "Usa il prefisso a due cifre ed estensione .md minuscola (es. 01-nome.md)."
                )

        parts: list[str] = []
        if versioning_path.is_file():
            v_text = read_clean(versioning_path)
            if v_text:
                parts.append(v_text)

        for sec in section_files:
            s_text = read_clean(sec)
            if s_text:
                parts.append(s_text)

        if not parts:
            print(f"[SKIP]           {folder.name} (contenuto vuoto)")
            continue

        chapter_body = "\n\n".join(parts)
        changed = sync_file(main_doc_path, chapter_body, dry_run=dry_run, check_only=check_only)
        any_out_of_sync = any_out_of_sync or changed

        if dry_run or check_only:
            label = "[DA AGGIORNARE]" if changed else "[INVARIATO]    "
        else:
            label = "[AGGIORNATO]    " if changed else "[INVARIATO]    "
        print(f"{label} {format_rel(docs_dir, main_doc_path)}")

        chapters.append(chapter_body)

    if not chapters:
        raise RuntimeError("Nessun contenuto valido trovato in docs/ da assemblare.")

    final_doc_path = docs_dir / "project-documentation.md"
    final_body = "\n\n---\n\n".join(chapters)
    changed = sync_file(final_doc_path, final_body, dry_run=dry_run, check_only=check_only)
    any_out_of_sync = any_out_of_sync or changed

    if dry_run or check_only:
        label = "[DA AGGIORNARE]" if changed else "[INVARIATO]    "
    else:
        label = "[AGGIORNATO]    " if changed else "[INVARIATO]    "
    print(f"{label} {format_rel(docs_dir, final_doc_path)}")

    if check_only and any_out_of_sync:
        return 1
    return 0


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="Genera i file di documentazione unificati.")
    parser.add_argument(
        "--docs-dir",
        help="Percorso personalizzato della cartella docs (utile per test su una copia).",
    )
    mode = parser.add_mutually_exclusive_group()
    mode.add_argument(
        "--dry-run",
        action="store_true",
        help="Simula l'esecuzione senza modificare alcun file su disco.",
    )
    mode.add_argument(
        "--check",
        action="store_true",
        help="Verifica che i file generati siano allineati (exit code 1 se non lo sono).",
    )
    return parser.parse_args()


if __name__ == "__main__":
    args = parse_args()
    try:
        docs_path = resolve_docs_dir(args.docs_dir)
        exit_code = build_docs(docs_path, dry_run=args.dry_run, check_only=args.check)
        sys.exit(exit_code)
    except Exception as exc:
        print(f"ERRORE: {exc}", file=sys.stderr)
        sys.exit(1)
