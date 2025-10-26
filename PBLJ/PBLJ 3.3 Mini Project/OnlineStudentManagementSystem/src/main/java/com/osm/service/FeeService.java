package com.osm.service;

import com.osm.model.Student;

public interface FeeService {
    void payFee(int studentId, double amount);
    void refundFee(int studentId, double amount);
    Student getStudentDetails(int studentId);
}
