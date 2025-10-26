package com.osm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osm.model.Course;

public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveCourse(Course course) {
        getCurrentSession().save(course);
    }

    @Override
    public void updateCourse(Course course) {
        getCurrentSession().update(course);
    }

    @Override
    public Course getCourseById(int id) {
        return getCurrentSession().get(Course.class, id);
    }

    @Override
    public void deleteCourse(int id) {
        Course course = getCourseById(id);
        if (course != null) {
            getCurrentSession().delete(course);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> getAllCourses() {
        return getCurrentSession().createQuery("from Course").list();
    }
}
