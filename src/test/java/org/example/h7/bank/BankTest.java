package org.example.h7.bank;

import org.example.h7.bank.Account;
import org.example.h7.bank.Accountmanager;
import org.example.h7.bank.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class BankTest {

    private Account account1;
    private Account account2;

    @Mock
    private Accountmanager accountManagerMock;

    @InjectMocks
    private Bank sut;

    @BeforeEach
    void setUpBank() {
        account1 = new Account();
        account2 = new Account();
        account1.setNumber(91);
        account2.setNumber(92);
        account1.setBalance(BigDecimal.valueOf(9000));
        account2.setBalance(BigDecimal.valueOf(9000));
    }

    @Test
    void addAccountsToListOfAccountsInAccountManager() {
        when(accountManagerMock.addAccount(any())).thenReturn(true);

        sut.add(account1);

        verify(accountManagerMock).addAccount(any());
    }

    @Test
    void showListOfAccountsInAccountManagerWhenCalled(){
        when(accountManagerMock.getAccounts()).thenReturn(new ArrayList<>());

        List<Account> getAccounts = accountManagerMock.getAccounts();

        assertEquals(getAccounts, new ArrayList<>());
    }

    @Test
    void checkIfBankCanLetEveryAccountGetInterest() {
        Accountmanager accountmanager = new Accountmanager();
        sut.setAccountmanager(accountmanager);
        sut.add(account1);
        sut.add(account2);

        sut.printNumberAndInterest();

        BigDecimal interestRate = Account.getInterest_rate();
        BigDecimal expectedBalance = interestRate.multiply(BigDecimal.valueOf(9000));
        assertEquals(account1.getBalance(), expectedBalance);
        assertEquals(account2.getBalance(), expectedBalance);
    }

    @Test
    void transferAssestsBetweenTwoAccountWithEnoughBalance() {
        Accountmanager accountmanager = new Accountmanager();
        sut.setAccountmanager(accountmanager);

        sut.add(account1);
        sut.add(account2);

        sut.transferAssestsBetweenBanks(account1.getNumber(), account2.getNumber(), 6000, sut);

        BigDecimal expectedBalanceAccount1 = BigDecimal.valueOf(3000);
        BigDecimal expectedBalanceAccount2 = BigDecimal.valueOf(15000);
        assertEquals(account1.getBalance(), expectedBalanceAccount1);
        assertEquals(account2.getBalance(), expectedBalanceAccount2);
    }

    @Test
    void transferMoneyBetweenTwoAccountFromDifferentBanks() {
        Bank ING = new Bank();
        Bank ABN = new Bank();
        Account account1 = new Account();
        Account account2 = new Account();
        Accountmanager accountmanager1 = new Accountmanager();
        Accountmanager accountmanager2 = new Accountmanager();
        ING.setAccountmanager(accountmanager1);
        ABN.setAccountmanager(accountmanager2);

        account1.setNumber(91);
        account2.setNumber(92);
        account1.setBalance(BigDecimal.valueOf(9000));
        account2.setBalance(BigDecimal.valueOf(9000));
        ING.add(account1);
        ABN.add(account2);

        ING.transferAssestsBetweenBanks(account1.getNumber(), account2.getNumber(), 6000, ABN);

        BigDecimal expectedBalanceAccount1 = BigDecimal.valueOf(3000);
        BigDecimal expectedBalanceAccount2 = BigDecimal.valueOf(15000);
        assertEquals(account1.getBalance(), expectedBalanceAccount1);
        assertEquals(account2.getBalance(), expectedBalanceAccount2);
    }

    @Test
    void transferAssestsBetweenTwoAccountWithNotEnoughBalance() {
        Bank bank = new Bank();
        Account account1 = new Account();
        Account account2 = new Account();
        Accountmanager accountmanager1 = new Accountmanager();

        bank.setAccountmanager(accountmanager1);
        account1.setNumber(91);
        account2.setNumber(92);
        account1.setBalance(BigDecimal.valueOf(5000));
        account2.setBalance(BigDecimal.valueOf(9000));
        bank.add(account1);
        bank.add(account2);

        bank.transferAssestsBetweenBanks(account1.getNumber(), account2.getNumber(), 6000, bank);

        BigDecimal expectedBalanceAccount1 = BigDecimal.valueOf(5000);
        BigDecimal expectedBalanceAccount2 = BigDecimal.valueOf(9000);
        assertEquals(account1.getBalance(), expectedBalanceAccount1);
        assertEquals(account2.getBalance(), expectedBalanceAccount2);
    }

    @Test
    void getTotalBalanceForThreeDifferentAccounts() {
        Bank bank = new Bank();
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        Accountmanager accountmanager1 = new Accountmanager();

        bank.setAccountmanager(accountmanager1);
        account1.setBalance(BigDecimal.valueOf(5000));
        account2.setBalance(BigDecimal.valueOf(9000));
        account3.setBalance(BigDecimal.valueOf(19000));
        bank.add(account1);
        bank.add(account2);
        bank.add(account3);

        BigDecimal totalBalance = bank.getTotalBalance();

        BigDecimal expectedTotalBalance = BigDecimal.valueOf(33000);
        assertEquals(totalBalance, expectedTotalBalance);
    }


}