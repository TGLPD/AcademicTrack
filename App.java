import java.util.Scanner;

/**
 * Main entry point for the AcademicTrack application.
 * Renamed to App to resolve naming conflict.
 */
public class App {
    // Fixed warnings: Added 'final'
    private static final DataManager dataManager = new DataManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("    Welcome to AcademicTrack System");
        System.out.println("===========================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput();

            // Fixed warnings: using standard switch for compatibility
            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    addCourseToStudent();
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMENU:");
        System.out.println("1. Register New Student");
        System.out.println("2. Add Course Grades");
        System.out.println("3. Generate GPA Report");
        System.out.println("4. Exit");
        System.out.print("Enter Choice: ");
    }

    private static void registerStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        if (dataManager.findStudent(id) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        Student newStudent = new Student(id, name);
        dataManager.addStudent(newStudent);
        System.out.println("Success: Student registered.");
    }

    private static void addCourseToStudent() {
        if (!dataManager.hasStudents()) {
            System.out.println("No students found. Register a student first.");
            return;
        }

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        Student s = dataManager.findStudent(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Name (e.g., Java Programming): ");
        String cName = scanner.nextLine();
        
        System.out.print("Enter Credits (e.g., 3 or 4): ");
        int credits = getIntInput();

        System.out.print("Enter Grade Achieved (A/B/C/D/F): ");
        String grade = scanner.nextLine();

        Course c = new Course(cName, credits, grade);
        s.addCourse(c);
        System.out.println("Success: Course added to record.");
    }

    private static void generateReport() {
        System.out.print("Enter Student ID for Report: ");
        String id = scanner.nextLine();
        Student s = dataManager.findStudent(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n===========================================");
        System.out.println("OFFICIAL TRANSCRIPT");
        System.out.println("Student: " + s.getName() + " (" + s.getStudentId() + ")");
        System.out.println("-------------------------------------------");
        
        if (s.getCourses().isEmpty()) {
            System.out.println("No courses recorded yet.");
        } else {
            for (Course c : s.getCourses()) {
                System.out.println(c);
            }
            System.out.println("-------------------------------------------");
            System.out.printf("Cumulative GPA: %.2f\n", s.calculateGPA());
        }
        System.out.println("===========================================");
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}