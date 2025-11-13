#!/bin/bash
echo "Compiling MST Edge Removal project..."
mkdir -p out
javac -d out src/main/java/mst/*.java
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Run './run.sh' to execute the program."
else
    echo "Compilation failed!"
    exit 1
fi

