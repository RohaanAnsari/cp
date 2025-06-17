#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Usage: ./run.sh <JavaFile.java>"
    exit 1
fi

filename="$1"
classname=$(basename "$filename" .java)

javac "$filename" && java "$classname" && rm -f "$classname.class"