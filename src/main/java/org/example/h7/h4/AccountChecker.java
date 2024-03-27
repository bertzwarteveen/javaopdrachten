package org.example.h7.h4;

public class AccountChecker {

    public void checkViability(String accountNumber) {
        try {
            accountNumber = accountNumber.replace(".", "");
            int sum = 0;
            for (int i = 0; i < accountNumber.length(); i++) {
                int accountDigit = Character.valueOf(accountNumber.charAt(i));
                sum = sum + accountDigit * (9 - i);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid account number");
        }
    }

    public void tableOfTen(int number) {
        for (int i = 1; i <= 10; i++) {
            int result = number * i;
            System.out.println(result);
        }
    }


public void getSeasonExp(Seasons season) {
    String warmth = switch (season) {
        case SPRING, SUMMER -> "warm";
        case FALL, WINTER -> "cold";
    };

    System.out.println(warmth);

}
}
