# Handoff

Date: 2026-04-01

## Current repo state

- Repo root: `/home/kjhwan/Work/hwpx`
- Branch: `main`
- Working tree: clean
- Remote:
  `origin https://github.com/dhxhghks/hwpx`

## Recent commits

- `b0f3300` Convert nested repos to normal directories
- `0fc3994` Initial commit

## What was done

- Created `trang.txt`
  Notes on using `trang` to infer an XSD from XML.
- Created `marshal_example.txt`
  Review summary of the JAXB example.
- Created `compress_example.txt`
  Review summary of the GZIP example.
- Added `marshal_example/README.md`
  Documents `.hpf -> XSD -> xjc -> JAXB` workflow.
- Added `marshal_example/generate_org_package.sh`
  Script to generate an inferred XSD with `trang` and then generate JAXB classes with `xjc`.
- Converted `marshal_example` and `compress_example` from nested git repos into normal directories in the outer repo.

## Important project details

- `marshal_example` is not a Gradle/Maven project. It is a simple Kotlin/JAXB example.
- `marshal_example/App.kt` contains JAXB usage, but it also contains extra code and may need cleanup before it builds cleanly.
- `marshal_example/generate_org_package.sh` expects:
  - `java`
  - `trang.jar`
  - either `xjc` on PATH or `jaxb-xjc.jar`

## GitHub push/auth status

- Remote is currently set to HTTPS:
  `https://github.com/dhxhghks/hwpx`
- SSH was tried and then reverted back to HTTPS.
- HTTPS push previously failed because GitHub credentials were not available in this environment.
- If push is still needed later, run:

```bash
git -C /home/kjhwan/Work/hwpx push -u origin main
```

If Git prompts for auth, use your normal GitHub login/token flow on your home machine.

## Useful commands to resume

Check status:

```bash
git -C /home/kjhwan/Work/hwpx status --short --branch
```

Push current branch:

```bash
git -C /home/kjhwan/Work/hwpx push -u origin main
```

Run the JAXB generation workflow:

```bash
cd /home/kjhwan/Work/hwpx/marshal_example
./generate_org_package.sh content.hpf /path/to/trang.jar org.idpf._2007.opf /path/to/jaxb-xjc.jar
```

## Suggested next step

- On your home machine, push `main` to GitHub over HTTPS.
- After that, if needed, clean up `marshal_example/App.kt` so the sample builds and runs cleanly.
