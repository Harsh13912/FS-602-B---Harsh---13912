package com.example.di.model;

public class Course {
    private String courseName;

    public Course() {
        this.courseName = "Computer Science";
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void printCourseDetails() {
        System.out.println("Enrolled in course: " + courseName);
    }
}
