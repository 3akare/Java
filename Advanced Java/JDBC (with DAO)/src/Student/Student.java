package Student;
public class Student {
    int id;
    String name;

    public Student() {
    };

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}