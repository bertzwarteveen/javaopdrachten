package org.example.h7.h5;

public class Methods {

    public int theGreatest(int a, int b) {
        return Math.max(a, b);
    }


    public int theGreatest(String a, String b) {
        return Math.max(a.length(), b.length());
    }

    public int factorial(int factor) {
        return factorial(factor, factor);
    }

    public int factorial(int factor, int sum){
        if (factor > 1){
            sum = sum * (factor - 1);
            factor = factor - 1;
            return factorial(factor, sum);
        }
        else
            return sum;
    }
}