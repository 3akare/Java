import Student.*;
public class Main {
    public static void main(String[] args) throws Exception {

        StudentDAO studentDAO = new StudentDAO(); //Data Access Object

        Student student = new Student("Henry");
        Student student2 = new Student("David");
        Student student3 = new Student("Johnson");
        
        studentDAO.connectToDB();
        studentDAO.addStudent(student);
        studentDAO.connectToDB();
        studentDAO.addStudent(student2);
        studentDAO.connectToDB();
        studentDAO.addStudent(student3);
        studentDAO.connectToDB();
        studentDAO.printAllStudents();
    }
}
