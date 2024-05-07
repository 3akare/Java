import java.io.IOException;
import java.util.Scanner;

public class Exceptions {

    public static String reader() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        scanner.close();
        return message;
    }

    public static void main(String[] args) {
        String message = null;
        try {
            System.out.print("$ ");
            message = reader();
        } catch (IOException error) {
            System.out.println("Error Reading File" + error.getMessage());
        } catch (Exception error) {
            System.err.println("Unknown Error: " + error.getMessage());
        } finally {
            System.out.println(message);
        }
    }
}