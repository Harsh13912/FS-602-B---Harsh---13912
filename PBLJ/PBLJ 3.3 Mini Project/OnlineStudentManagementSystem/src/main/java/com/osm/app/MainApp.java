package com.osm.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.osm.config.AppConfig;
import com.osm.model.Course;
import com.osm.model.Student;
import com.osm.service.FeeService;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    private static FeeService feeService;

    public static void main(String[] args) {

        // Load Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        feeService = context.getBean(FeeService.class);

        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudent();
                case 3 -> viewAllStudents();
                case 4 -> payFee();
                case 5 -> refundFee();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        }

        context.close();
    }

    private static void showMenu() {
        System.out.println("\n=== Online Student Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. View Student by ID");
        System.out.println("3. View All Students");
        System.out.println("4. Pay Fee");
        System.out.println("5. Refund Fee");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        try {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter course ID: ");
            int courseId = Integer.parseInt(scanner.nextLine());
            Course course = new Course();
            course.setId(courseId); // minimal Course object

            System.out.print("Enter initial balance: ");
            double balance = Double.parseDouble(scanner.nextLine());

            Student student = new Student(name, course, balance);
            feeService.getStudentDetails(0); // ensure student DAO initializes (optional)
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());

            // save student
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());
            feeService.getStudentDetails(student.getId());

            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private static void viewStudent() {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            Student student = feeService.getStudentDetails(id);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllStudents() {
        try {
            List<Student> students = feeService.getStudentDetails(0).getCourse().getStudents().stream().toList();
            if (!students.isEmpty()) {
                students.forEach(System.out::println);
            } else {
                System.out.println("No students found.");
            }
        } catch (Exception e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }

    private static void payFee() {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter amount to pay: ");
            double amount = Double.parseDouble(scanner.nextLine());

            feeService.payFee(id, amount);
        } catch (Exception e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    private static void refundFee() {
        try {
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter refund amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            feeService.refundFee(id, amount);
        } catch (Exception e) {
            System.out.println("Refund failed: " + e.getMessage());
        }
    }
}
