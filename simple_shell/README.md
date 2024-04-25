# Simple Shell

A simple Java-based command interpreter that reads commands from standard input and executes them.

## Usage

1. **Compilation:**

   Compile the Java source files using:
   ```shell
   javac -d . src/Main.java
   ```

2. **Execution:**

   Run the compiled program using:
   ```shell
   java Main
   ```

## Supported Commands

- `ls`: List files in the current directory.
- `mkdir <directory>`: Create a new directory.
- `rm <file1> [<file2> ...]`: Remove a file.
- `rename <oldName> <newName>`: Rename a file.
- `details <file>`: Display details of a file.
- `history`: Display command history.
- `touch <file1> [<file2> ...]`: Create new files.
- `cd <directory>`: Change the working directory.
- `pwd`: Print the current working directory.
- `clear`: Clear the screen.

## Additional Notes

- The shell supports only interactive mode of operation.
- For each command, appropriate usage instructions and error handling are provided.
- Basic file manipulation operations such as creation, deletion, renaming, copying, and moving are supported.
- File system navigation commands like changing directories and listing files are also available.
