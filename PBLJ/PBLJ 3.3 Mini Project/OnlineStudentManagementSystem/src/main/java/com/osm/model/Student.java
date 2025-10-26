package com.osm.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    // Many students can enroll in one course
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "balance")
    private double balance;

    public Student() {}

    public Student(String name, Course course, double balance) {
        this.name = name;
        this.course = course;
        this.balance = balance;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", course=" + (course != null ? course.getCourseName() : "None") + ", balance=" + balance + "]";
    }
}
