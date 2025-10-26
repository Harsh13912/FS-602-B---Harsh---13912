package com.osm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "amount")
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date")
    private Date date;

    public Payment() {}

    public Payment(Student student, double amount, Date date) {
        this.student = student;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "Payment [id=" + id + ", student=" + (student != null ? student.getName() : "None") + ", amount=" + amount + ", date=" + date + "]";
    }
}
