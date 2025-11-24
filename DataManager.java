import java.util.ArrayList;
import java.util.List;

/**
 * Manages the collection of students.
 * Acts as a mock database layer.
 */
public class DataManager {
    private List<Student> students;

    public DataManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public Student findStudent(String id) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null; // Student not found
    }

    public boolean hasStudents() {
        return !students.isEmpty();
    }
}