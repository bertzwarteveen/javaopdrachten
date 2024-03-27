package org.example.h7.bank;

import org.example.h7.bank.Account;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void testWithdrawingBalance() {
        // Setup
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(9000));

        // Execution
        account.withdrawBalance(BigDecimal.valueOf(6000));

        // Assertion
        BigDecimal expectedBalance = BigDecimal.valueOf(3000);
        assertEquals(expectedBalance, account.getBalance());
    }
    @Test
    void testWithdrawingBalanceTooMuch() {
        // Setup
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(9000));

        // Execution
        account.withdrawBalance(BigDecimal.valueOf(10000));

        // Assertion
        BigDecimal expectedBalance = BigDecimal.valueOf(9000);
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void testDepositBalance() {
        // Setup
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(9000));

        // Execution
        account.depositBalance(BigDecimal.valueOf(8000));

        //Assertion
        BigDecimal expectedBalance = BigDecimal.valueOf(17000);
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void testGainInterest() {
        // Setup
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(9000));

        // Exe
        account.gainInterest();

        // Ass
        BigDecimal interestRate = Account.getInterest_rate();
        BigDecimal expectedBalance = interestRate.multiply(BigDecimal.valueOf(9000));
        assertEquals(expectedBalance, account.getBalance());
    }
}