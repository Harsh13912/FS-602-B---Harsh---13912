package com.example.banking.config;

import com.example.banking.dao.AccountDAO;
import com.example.banking.service.BankingService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration as SpringConfig;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringConfig
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    @Bean
    public AccountDAO accountDAO() {
        return new AccountDAO(sessionFactory());
    }

    @Bean
    public BankingService bankingService() {
        return new BankingService(accountDAO());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }
}
