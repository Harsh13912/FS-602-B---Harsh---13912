import java.io.*;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline left-over

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }

        } while (choice != 3);

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Employee Designation: ");
            String designation = scanner.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // consume leftover newline

            // Format employee details as CSV: name,id,designation,salary
            String employeeRecord = name + "," + id + "," + designation + "," + salary;

            // Append to the file
            writer.write(employeeRecord);
            writer.newLine();

            System.out.println("Employee added successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void displayAllEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nEmployee Records:");
            System.out.println("---------------------------------------");
            System.out.printf("%-20s %-10s %-15s %10s%n", "Name", "ID", "Designation", "Salary");
            System.out.println("---------------------------------------");

            boolean hasRecords = false;

            while ((line = reader.readLine()) != null) {
                hasRecords = true;
                // Each line format: name,id,designation,salary
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    String id = parts[1];
                    String designation = parts[2];
                    String salary = parts[3];

                    System.out.printf("%-20s %-10s %-15s %10s%n", name, id, designation, salary);
                }
            }

            if (!hasRecords) {
                System.out.println("No employee records found.");
            }

            System.out.println("---------------------------------------");

        } catch (FileNotFoundException e) {
            System.out.println("No employee data found. Please add employees first.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
