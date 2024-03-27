package org.example.h7.bank;

import java.math.BigDecimal;

public class Account {
    private int number; // had IBAN class toe kunnen voegen.
    private BigDecimal balance = BigDecimal.valueOf(0);
    private static final BigDecimal interest_rate = BigDecimal.valueOf(1.013);

    public static BigDecimal getInterest_rate() {
        return interest_rate;
    }

    public int getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void withdrawBalance(BigDecimal withdrawAmount) {
        if(this.balance.compareTo(withdrawAmount) >= 0) {
            this.balance = this.balance.subtract(withdrawAmount);
        }
        else{
            // voeg exception toe
            System.out.println("Insufficient balance");
        }
    }

    public void depositBalance(BigDecimal depositAmount) {
        if (depositAmount.compareTo(BigDecimal.ZERO) > 0) {
            this.balance = this.balance.add(depositAmount);
        }
          // voeg exception toe
        }


    public void gainInterest() {
        this.balance = this.balance.multiply(getInterest_rate());
    }

}

