import java.io.*;

// Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int studentID;
    private String name;
    private double grade;

    public Student(int studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}

public class StudentSerializationDemo {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice", 9.2);

        // File to store serialized object
        String filename = "student.ser";

        // --- Serialization ---
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(student);
            System.out.println("Student object has been serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- Deserialization ---
        Student deserializedStudent = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedStudent = (Student) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Print deserialized object
        if (deserializedStudent != null) {
            System.out.println("Deserialized Student object:");
            System.out.println(deserializedStudent);
        }
    }
}