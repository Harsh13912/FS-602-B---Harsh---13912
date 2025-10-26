package com.osm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osm.model.Student;

public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveStudent(Student student) {
        getCurrentSession().save(student);
    }

    @Override
    public void updateStudent(Student student) {
        getCurrentSession().update(student);
    }

    @Override
    public Student getStudentById(int id) {
        return getCurrentSession().get(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            getCurrentSession().delete(student);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {
        return getCurrentSession().createQuery("from Student").list();
    }
}
