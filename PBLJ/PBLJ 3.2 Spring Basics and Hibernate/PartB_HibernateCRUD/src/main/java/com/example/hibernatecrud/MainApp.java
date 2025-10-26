package com.example.hibernatecrud;

import com.example.hibernatecrud.dao.StudentDAO;
import com.example.hibernatecrud.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Build SessionFactory from hibernate.cfg.xml
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        StudentDAO studentDAO = new StudentDAO(sessionFactory);

        // Create
        Student s1 = new Student("Alice", 20);
        Student s2 = new Student("Bob", 22);
        studentDAO.saveStudent(s1);
        studentDAO.saveStudent(s2);

        // Read
        Student student = studentDAO.getStudent(s1.getId());
        System.out.println("Read student: " + student);

        List<Student> students = studentDAO.getAllStudents();
        System.out.println("All students:");
        students.forEach(System.out::println);

        // Update
        student.setAge(21);
        studentDAO.updateStudent(student);
        System.out.println("Updated student: " + studentDAO.getStudent(student.getId()));

        // Delete
        studentDAO.deleteStudent(s2.getId());
        System.out.println("All students after deletion:");
        studentDAO.getAllStudents().forEach(System.out::println);

        // Close SessionFactory
        sessionFactory.close();
    }
}
