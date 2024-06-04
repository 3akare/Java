import Student.*;
public class Main {
    public static void main(String[] args) throws Exception {

        StudentDAO studentDAO = new StudentDAO(); //Data Access Object

        Student student = new Student("Henry");
        Student student2 = new Student("David");
        Student student3 = new Student("Johnson");
        
        studentDAO.addStudent(student);
        studentDAO.addStudent(student2);
        studentDAO.addStudent(student3);

        studentDAO.printAllStudents();
    }
}
