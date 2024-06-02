import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String URL = "jdbc:mysql://localhost:3306/portkeeper";
        String username = "root";
        String password = "0987";
        String query = "SELECT * FROM port_service_mapping";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, username, password);
                Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println(
                    result.getInt(1) + " " + 
                    result.getString(2) + " " +
                    result.getString(3) + " " +
                    result.getString(4) + " " +
                    result.getString(5) + " " +
                    result.getString(6) + " " 
                    );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}