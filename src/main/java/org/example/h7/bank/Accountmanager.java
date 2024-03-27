package org.example.h7.bank;

import java.util.ArrayList;
import java.util.List;

public class Accountmanager {
    private final List<Account> accounts = new ArrayList<>();

    public boolean addAccount(Account newAccount) {
        this.accounts.add(newAccount);
        return true;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
