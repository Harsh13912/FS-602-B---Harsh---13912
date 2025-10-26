package com.osm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osm.dao.StudentDAO;
import com.osm.dao.PaymentDAO;
import com.osm.model.Payment;
import com.osm.model.Student;

@Service
public class FeeServiceImpl implements FeeService {

    private StudentDAO studentDAO;
    private PaymentDAO paymentDAO;

    @Autowired
    public FeeServiceImpl(StudentDAO studentDAO, PaymentDAO paymentDAO) {
        this.studentDAO = studentDAO;
        this.paymentDAO = paymentDAO;
    }

    @Override
    @Transactional
    public void payFee(int studentId, double amount) {
        Student student = studentDAO.getStudentById(studentId);
        if (student == null) {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }

        // Deduct fee from balance
        double newBalance = student.getBalance() - amount;
        if (newBalance < 0) {
            throw new RuntimeException("Insufficient balance for payment!");
        }
        student.setBalance(newBalance);
        studentDAO.updateStudent(student);

        // Record payment
        Payment payment = new Payment(student, amount, new Date());
        paymentDAO.savePayment(payment);

        System.out.println("Payment successful: $" + amount + " for " + student.getName());
    }

    @Override
    @Transactional
    public void refundFee(int studentId, double amount) {
        Student student = studentDAO.getStudentById(studentId);
        if (student == null) {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }

        // Add refund to balance
        double newBalance = student.getBalance() + amount;
        student.setBalance(newBalance);
        studentDAO.updateStudent(student);

        // Record negative payment as refund
        Payment refund = new Payment(student, -amount, new Date());
        paymentDAO.savePayment(refund);

        System.out.println("Refund successful: $" + amount + " to " + student.getName());
    }

    @Override
    public Student getStudentDetails(int studentId) {
        return studentDAO.getStudentById(studentId);
    }
}
