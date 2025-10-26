package com.osm.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "duration")
    private String duration;

    // Optional: mappedBy if you want bidirectional relationship
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Student> students;

    public Course() {}

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public Set<Student> getStudents() { return students; }
    public void setStudents(Set<Student> students) { this.students = students; }

    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", duration=" + duration + "]";
    }
}
