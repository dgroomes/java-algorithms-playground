#!/usr/bin/env bash
# Compile the program source code.
#
# Note: this script works on macOS and Linux but not Windows.
#
# This script finds all the source code files in the "src/" directory and writes the file names to a file named "sources.txt".
# Then the Java compiler (javac) compiles the source code and places the resulting ".class" files in the "out/" directory.
#
# Now, the program can be executed via its main method. See the README for more information.

find src -name "*.java" > sources.txt
javac \
  @sources.txt \
  -d out \
  --release 19 \
  --enable-preview
