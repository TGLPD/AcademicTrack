/**
 * Represents a single course taken by a student.
 * Stores course name, credit hours, and the letter grade achieved.
 */
public class Course {
    private String courseName;
    private int credits;
    private String grade; // A, B, C, D, F

    public Course(String courseName, int credits, String grade) {
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
    }

    // Getters
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public String getGrade() { return grade; }

    /**
     * Converts letter grade to numeric point value.
     * A = 4.0, B = 3.0, C = 2.0, D = 1.0, F = 0.0
     */
    public double getGradePoint() {
        switch (grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }

    @Override
    public String toString() {
        return String.format("%-20s | Credits: %d | Grade: %s", courseName, credits, grade);
    }
}