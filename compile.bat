@echo off
echo Compiling MST Edge Removal project...
if not exist out mkdir out
javac -d out src/main/java/mst/*.java
if %errorlevel% equ 0 (
    echo Compilation successful!
    echo Run 'run.bat' to execute the program.
) else (
    echo Compilation failed!
    exit /b 1
)

