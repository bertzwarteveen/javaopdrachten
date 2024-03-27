package org.example.h7.bank;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Accountmanager accountmanager = new Accountmanager();
        bank.setAccountmanager(accountmanager);
        Account account1 = new Account();
        Account account2 = new Account();
        account1.setNumber(91);
        account2.setNumber(92);
        account1.setBalance(BigDecimal.valueOf(9000));
        account2.setBalance(BigDecimal.valueOf(9000));
        accountmanager.addAccount(account1);
        accountmanager.addAccount(account2);

        bank.printNumberAndInterest();
    }
}