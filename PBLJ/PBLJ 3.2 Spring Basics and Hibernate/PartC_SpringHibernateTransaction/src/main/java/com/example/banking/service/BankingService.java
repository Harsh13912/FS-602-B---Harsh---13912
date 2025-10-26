package com.example.banking.service;

import com.example.banking.dao.AccountDAO;
import com.example.banking.model.Account;
import org.springframework.transaction.annotation.Transactional;

public class BankingService {

    private AccountDAO accountDAO;

    public BankingService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) throws Exception {
        Account fromAccount = accountDAO.getAccount(fromId);
        Account toAccount = accountDAO.getAccount(toId);

        if (fromAccount.getBalance() < amount) {
            throw new Exception("Insufficient funds in account " + fromId);
        }

        // Deduct money
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountDAO.updateAccount(fromAccount);

        // Add money
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountDAO.updateAccount(toAccount);

        System.out.println("Transferred " + amount + " from " + fromAccount.getName() + " to " + toAccount.getName());
    }
}
