#!/usr/bin/env bash
set -euo pipefail

if [[ $# -lt 3 || $# -gt 4 ]]; then
  cat <<'EOF'
Usage:
  ./generate_org_package.sh <input.hpf> <trang.jar> <package.name> [xjc-or-jaxb-xjc.jar]

Examples:
  ./generate_org_package.sh content.hpf /path/to/trang.jar org.idpf._2007.opf
  ./generate_org_package.sh content.hpf /path/to/trang.jar org.idpf._2007.opf /path/to/jaxb-xjc.jar

Behavior:
  1. Infer an XSD from the input .hpf file with trang
  2. Generate JAXB classes into src-gen/<package path> with xjc

Notes:
  - If the 4th argument is omitted, the script tries to use a system `xjc` command.
  - If `xjc` is not installed, pass the path to `jaxb-xjc.jar` as the 4th argument.
EOF
  exit 1
fi

INPUT_HPF=$1
TRANG_JAR=$2
PACKAGE_NAME=$3
XJC_TOOL=${4:-}

if [[ ! -f "$INPUT_HPF" ]]; then
  echo "Input file not found: $INPUT_HPF" >&2
  exit 1
fi

if [[ ! -f "$TRANG_JAR" ]]; then
  echo "trang.jar not found: $TRANG_JAR" >&2
  exit 1
fi

BASE_DIR=$(cd "$(dirname "$0")" && pwd)
OUT_DIR="$BASE_DIR/src-gen"
SCHEMA_DIR="$BASE_DIR/schema-gen"
SCHEMA_FILE="$SCHEMA_DIR/$(basename "${INPUT_HPF%.*}").xsd"

mkdir -p "$OUT_DIR" "$SCHEMA_DIR"

echo "[1/2] Generating XSD with trang"
java -jar "$TRANG_JAR" -I xml -O xsd "$INPUT_HPF" "$SCHEMA_FILE"

echo "[2/2] Generating JAXB classes into package $PACKAGE_NAME"
if [[ -n "$XJC_TOOL" ]]; then
  if [[ ! -f "$XJC_TOOL" ]]; then
    echo "xjc tool jar not found: $XJC_TOOL" >&2
    exit 1
  fi
  java -jar "$XJC_TOOL" -d "$OUT_DIR" -p "$PACKAGE_NAME" "$SCHEMA_FILE"
else
  if ! command -v xjc >/dev/null 2>&1; then
    echo "xjc command not found. Install xjc or pass jaxb-xjc.jar as the 4th argument." >&2
    exit 1
  fi
  xjc -d "$OUT_DIR" -p "$PACKAGE_NAME" "$SCHEMA_FILE"
fi

echo
echo "Generated schema:"
echo "  $SCHEMA_FILE"
echo "Generated sources:"
echo "  $OUT_DIR"
