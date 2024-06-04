import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String URL = "jdbc:mysql://localhost:3306/crud_app";
        String username = "root";
        String password = "0987";
        String query = "SELECT * FROM jdbc";
        String insertQuery = "INSERT INTO jdbc(name) VALUES (?)";

        Class.forName("com.mysql.cj.jdbc.Driver"); // Used for loading in drivers during runtime

        // DDL - Data Definition Layer, DML - Data Manipulation Language, DQL - Data
        // Query Langauge
        // DAO - Data Access Object

        try (Connection connection = DriverManager.getConnection(URL, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                Statement statement = connection.createStatement()) {
            preparedStatement.setString(1, "David");
            int count = preparedStatement.executeUpdate();
            ResultSet result = statement.executeQuery(query);

            System.out.println("Number of row(s) affected: " + count);

            while (result.next()) {
                System.out.println(
                        result.getInt(1) + " " + result.getString(2));
            }

            preparedStatement.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}