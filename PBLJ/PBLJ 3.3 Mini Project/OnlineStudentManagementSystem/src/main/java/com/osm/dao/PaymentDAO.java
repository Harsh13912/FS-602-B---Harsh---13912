package com.osm.dao;

import java.util.List;
import com.osm.model.Payment;

public interface PaymentDAO {
    void savePayment(Payment payment);
    List<Payment> getPaymentsByStudentId(int studentId);
}


// package com.osm.dao;

// import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

// import com.osm.model.Payment;

public class PaymentDAOImpl implements PaymentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void savePayment(Payment payment) {
        getCurrentSession().save(payment);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Payment> getPaymentsByStudentId(int studentId) {
        return getCurrentSession()
                .createQuery("from Payment where student.id = :sid")
                .setParameter("sid", studentId)
                .list();
    }
}
