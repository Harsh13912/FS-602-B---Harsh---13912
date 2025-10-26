package com.osm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.osm.dao.StudentDAOImpl;
import com.osm.dao.CourseDAOImpl;
import com.osm.dao.PaymentDAO;
import com.osm.dao.StudentDAO;
import com.osm.dao.CourseDAO;
import com.osm.service.FeeService;
import com.osm.service.FeeServiceImpl;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    // DataSource bean (DB connection)
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Change if using H2
        ds.setUrl("jdbc:mysql://localhost:3306/osm_db");   // Your DB name
        ds.setUsername("root");                             // Your DB username
        ds.setPassword("password");                         // Your DB password
        return ds;
    }

    // Hibernate SessionFactory bean
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.osm.model"); // package with @Entity classes

        Properties hibernateProps = new Properties();
        hibernateProps.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProps.put("hibernate.show_sql", "true");
        hibernateProps.put("hibernate.hbm2ddl.auto", "update"); // use "create" for first run
        sessionFactory.setHibernateProperties(hibernateProps);

        return sessionFactory;
    }

    // Transaction Manager
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    // DAO beans
    @Bean
    public StudentDAO studentDAO() {
        return new StudentDAOImpl();
    }

    @Bean
    public CourseDAO courseDAO() {
        return new CourseDAOImpl();
    }

    @Bean
    public PaymentDAO paymentDAO() {
        return new PaymentDAO(); // implement if needed
    }

    // Service bean
    @Bean
    public FeeService feeService() {
        return new FeeServiceImpl(studentDAO(), paymentDAO());
    }
}
