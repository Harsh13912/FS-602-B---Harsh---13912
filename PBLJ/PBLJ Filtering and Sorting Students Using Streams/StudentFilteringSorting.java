import java.util.ArrayList;
import java.util.List;

public class StudentFilteringSorting {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 82.5));
        students.add(new Student("Bob", 68.0));
        students.add(new Student("Charlie", 91.0));
        students.add(new Student("David", 74.5));
        students.add(new Student("Eva", 88.0));

        System.out.println("Students scoring above 75%, sorted by marks:");

        students.stream()
                .filter(s -> s.getMarks() > 75)                       // Filter marks > 75%
                .sorted((s1, s2) -> Double.compare(s1.getMarks(), s2.getMarks())) // Sort by marks ascending
                .map(Student::getName)                                // Map to names only
                .forEach(System.out::println);                        // Print names
    }
}
