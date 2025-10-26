package com.example.di;

import com.example.di.config.AppConfig;
import com.example.di.model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Initialize Spring context using Java-based configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Student bean
        Student student = context.getBean(Student.class);

        // Call method to demonstrate dependency injection
        student.showStudentDetails();

        // Close context
        context.close();
    }
}
