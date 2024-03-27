package org.example.h7.bank;

import java.math.BigDecimal;
import java.util.List;

public class Bank {
    private Accountmanager accountmanager;

    public void setAccountmanager(Accountmanager accountmanager) {
        this.accountmanager = accountmanager;
    }


    public void printNumberAndInterest() {
        for (Account account : accountmanager.getAccounts()) {
            System.out.println(account.getNumber());
            System.out.println(account.getBalance());
            account.gainInterest();
            System.out.println(account.getBalance());
        }
    }
    public void add (Account newAccount){
        this.accountmanager.addAccount(newAccount);
    }
    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = BigDecimal.valueOf(0);
        for (Account account : accountmanager.getAccounts()) {
            totalBalance = totalBalance.add(account.getBalance());
        }
        return totalBalance;
    }

    public void transferAssestsBetweenBanks(int fromAccountNumber, int toAccountNumber, int amount, Bank toBank) {
        Account account1 = null;
        Account account2 = null;
        List<Account> toBankAccounts = toBank.accountmanager.getAccounts();

        for (Account account : accountmanager.getAccounts()) {
            if (account.getNumber() == fromAccountNumber) {
                account1 = account;
            }
            // voeg exception toe
        }

        for (Account account : toBankAccounts) {
            if (account.getNumber() == toAccountNumber) {
                account2 = account;
            }
            // voeg exception toe
        }

        if (account1 != null && account2 != null) {
            BigDecimal preWithdrawBalance = account1.getBalance();
            account1.withdrawBalance(BigDecimal.valueOf(amount));

            if (!preWithdrawBalance.equals(account1.getBalance())) {
                account2.depositBalance(BigDecimal.valueOf(amount));
            }
            // voeg exception toe
        }
        // voeg exception toe
    }
}