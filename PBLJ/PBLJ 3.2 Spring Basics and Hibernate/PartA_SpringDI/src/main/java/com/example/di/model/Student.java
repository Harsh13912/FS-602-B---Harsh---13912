package com.example.di.model;

public class Student {
    private Course course;
    private String name;

    // Constructor injection
    public Student(Course course) {
        this.course = course;
        this.name = "John Doe";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showStudentDetails() {
        System.out.println("Student Name: " + name);
        course.printCourseDetails();
    }
}
