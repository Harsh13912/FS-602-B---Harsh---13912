package com.osm.dao;

import java.util.List;
import com.osm.model.Course;

public interface CourseDAO {
    void saveCourse(Course course);
    void updateCourse(Course course);
    Course getCourseById(int id);
    void deleteCourse(int id);
    List<Course> getAllCourses();
}
