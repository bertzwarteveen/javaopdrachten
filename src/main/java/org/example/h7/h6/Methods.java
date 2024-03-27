package org.example.h7.h6;

public class Methods {

    public long[] doubleArray(long[] array) {
        long[] doubledArray = new long[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            doubledArray[i] = array[i];
        }
        return doubledArray;
    }

    public long[] multiplyItems(long[] array, int multiplier) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
            array[i] = array[i] * multiplier;
        }
        return array;
    }

    // n + n
    public long[] run(int n) {
        if (n < 93) {
            long[] f = new long[n];{};
            for (int i = 0; i < n; i++) {
                f[i] = (i < 2) ? 1 : f[i-2] + f[i-1];
            }
            return f;
        }
        else return null;
    }
}
