import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Student entity.
 * Manages the list of courses and calculates GPA.
 */
public class Student {
    private String studentId;
    private String name;
    private List<Course> courses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public List<Course> getCourses() { return courses; }

    /**
     * Calculates the GPA based on the formula:
     * Total Points = Sum of (Course Credits * Grade Points)
     * GPA = Total Points / Total Credits
     */
    public double calculateGPA() {
        if (courses.isEmpty()) return 0.0;

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Course c : courses) {
            totalPoints += (c.getGradePoint() * c.getCredits());
            totalCredits += c.getCredits();
        }

        if (totalCredits == 0) return 0.0;
        return totalPoints / totalCredits;
    }
}