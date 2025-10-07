import java.util.List;
import java.util.Scanner;

public class StudentView {
    private Scanner scanner = new Scanner(System.in);

    public int showMenuAndGetChoice() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
        return scanner.nextInt();
    }

    public Student getStudentDetails() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        return new Student(id, name, dept, marks);
    }

    public int getStudentId(String action) {
        System.out.printf("Enter Student ID to %s: ", action);
        int id = scanner.nextInt();
        return id;
    }

    public void showStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nStudents List:");
            students.forEach(System.out::println);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
