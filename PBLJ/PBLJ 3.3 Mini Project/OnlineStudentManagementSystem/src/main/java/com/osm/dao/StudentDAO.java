package com.osm.dao;

import java.util.List;
import com.osm.model.Student;

public interface StudentDAO {
    void saveStudent(Student student);
    void updateStudent(Student student);
    Student getStudentById(int id);
    void deleteStudent(int id);
    List<Student> getAllStudents();
}
