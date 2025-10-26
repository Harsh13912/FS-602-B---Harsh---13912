package com.example.di.config;

import com.example.di.model.Course;
import com.example.di.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("Artificial Intelligence");
    }

    @Bean
    public Student student() {
        return new Student(course());
    }
}
