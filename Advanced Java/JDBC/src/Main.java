import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String URL = "jdbc:mysql://localhost:3306/crud_app";
        String username = "root";
        String password = "0987";
        String query = "SELECT * FROM jdbc";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, username, password);
                Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println("id: " + result.getInt(1) + " " + " name: " +
                    result.getString(2)
                    );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}