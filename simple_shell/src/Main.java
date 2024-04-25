import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static final Scanner scanner = new Scanner(System.in);
    public static final List<String> historyDataList = new ArrayList<>();
    public static String currentWorkingDirectory = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        String commandLineString;
        String[] tokenizeCommandLineString;
        List<String> availableCommands = Arrays.asList("ls", "cd","rm","pwd", "details", "history","exit");
        String command;
        String argument;
        boolean loopStatus = true;

        while(loopStatus){
            System.out.print("$(jsh) " + currentWorkingDirectory + "> ");
            commandLineString = scanner.nextLine();
            tokenizeCommandLineString = commandLineString.split("\\s+", 2);
            command = tokenizeCommandLineString[0];

            //verify and add commands to history list
            if(!command.isEmpty() && availableCommands.contains(command)) {
                historyDataList.add(commandLineString);
            }

            switch(command){
                case "ls":
                   listFiles();
                    break;
                case "cd":
                    if (tokenizeCommandLineString.length > 1){
                        argument = tokenizeCommandLineString[1];
                        changeDirectory(argument);
                    }
                    else { System.out.println("cd: missing argument"); }
                    break;
                case "rm":
                    removeFile(commandLineString);
                    break;
                case "touch":
                    createFile(commandLineString);
                    break;
                case "pwd":
                   printCurrentWorkingDirectory();
                    break;
                case "history":
                    printHistory();
                    break;
                case "clear":
                    clearScreen();
                    break;
                case "details":
                    if (tokenizeCommandLineString.length > 1){
                        argument = tokenizeCommandLineString[1];
                        getFileDetails(argument);
                    }
                    else {
                        System.out.println("details: missing argument");
                    }
                    break;
                case "exit":
                    loopStatus = false;
                    break;
                default:
                    System.out.println(tokenizeCommandLineString[0] + " :command not found");
            }
        }
    }
    public static void printHistory(){
        for (String historyData: historyDataList){
            System.out.println(historyData);
        }
    }

    public static void listFiles(){
        File directory = new File(currentWorkingDirectory);
        File[] files = directory.listFiles();
        // I don't know what this does but intellij suggested it.
        assert files != null;
        for (File file: files){
            if (file.isDirectory()) System.out.print("/");
            System.out.println(file.getName());
        }
    }

    public static void changeDirectory(String argument){
        String newDirectory = argument;

        if (!newDirectory.startsWith("/") && !newDirectory.startsWith("..")) {
            newDirectory = currentWorkingDirectory + "/" + argument;
        }
        File file = new File(newDirectory);
        if (file.exists() && file.isDirectory()) {
            currentWorkingDirectory = file.getAbsolutePath();
        } else {
            System.out.println("cd: " + argument + ": No such directory");
        }
    }

    public static void printCurrentWorkingDirectory(){
        System.out.println(System.getProperty("user.dir"));
    }

    public static void getFileDetails(String filename){
        File file = new File(filename);
        if (file.isFile() && file.exists()) {
            LocalDateTime lastModifiedDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault());
            System.out.printf("file name: %s\nfile size: %d\nlast modified: ", file.getName(), file.length());
            System.out.println(lastModifiedDateTime);
            return;
        }
        System.out.println(filename + " is not a file");
    }

    public static void createFile(String arguments) throws IOException {
        String[] commandArgs = arguments.split("\\s+");
//        File newFile = new File(commandArgs)

        for (int i = 1; i < commandArgs.length; i++){
            File newfile = new File(commandArgs[i]);
            if (newfile.exists()) continue;
            newfile.createNewFile();
        }

    }

    public static void removeFile(String arguments){
        String[] commandArgs = arguments.split("\\s+");
//        File fileToDelete = new File(commandArgs)

        for (int i = 1; i < commandArgs.length; i++){
            File fileToDelete = new File(commandArgs[i]);
            if (fileToDelete.isDirectory()) {
                System.out.println("rm: cannot remove '" + fileToDelete.getName() + "': Is a directory");
                return;
            }
            if (fileToDelete.exists()) fileToDelete.delete();
        }
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}