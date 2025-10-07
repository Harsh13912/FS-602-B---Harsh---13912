import java.util.ArrayList;
import java.util.List;

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alice", 30, 75000));
        employees.add(new Employee("Bob", 25, 50000));
        employees.add(new Employee("Charlie", 35, 60000));
        employees.add(new Employee("David", 28, 90000));

        // Sort by name (alphabetically)
        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        System.out.println("Sorted by name:");
        employees.forEach(System.out::println);

        // Sort by age (ascending)
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("\nSorted by age:");
        employees.forEach(System.out::println);

        // Sort by salary (descending)
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("\nSorted by salary (descending):");
        employees.forEach(System.out::println);
    }
}
