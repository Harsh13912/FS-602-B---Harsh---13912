package com.example.banking;

import com.example.banking.config.AppConfig;
import com.example.banking.model.Account;
import com.example.banking.service.BankingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BankingService bankingService = context.getBean(BankingService.class);

        // Initialize accounts (normally, use DAO)
        Account acc1 = new Account("Alice", 1000);
        Account acc2 = new Account("Bob", 500);

        context.getBeanFactory().getBean("accountDAO", com.example.banking.dao.AccountDAO.class).saveAccount(acc1);
        context.getBeanFactory().getBean("accountDAO", com.example.banking.dao.AccountDAO.class).saveAccount(acc2);

        // Perform transfer
        try {
            bankingService.transferMoney(acc1.getId(), acc2.getId(), 200);
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        context.close();
    }
}
