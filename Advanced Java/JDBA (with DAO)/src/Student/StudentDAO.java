package Student;

import java.sql.*;

public class StudentDAO {
    private String url = "jdbc:mysql://localhost:3306/crud_app";
    private String user = "root";
    private String password = "0987";
    Connection connection = null;

    public void connectToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Student getStudent(int id) throws ClassNotFoundException, SQLException {
        Student student = new Student();
        student.id = id;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM jdbc WHERE id=" + id);
        result.next();
        student.setName(result.getString(2));
        statement.close();
        connection.close();
        return student;
    }

    public void addStudent(Student student) throws ClassNotFoundException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jdbc(name) VALUES (?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void deleteStudent(int id) throws ClassNotFoundException, SQLException {
        String deleteQuery = "DELETE FROM jdbc WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void printAllStudents() throws ClassNotFoundException, SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM jdbc");

        while (result.next()) {
            System.out.println("id: " + result.getInt(1) + " name: " + result.getString(2));
        }
    }
}
