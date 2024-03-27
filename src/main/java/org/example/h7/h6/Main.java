package org.example.h7.h6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Methods methods = new Methods();
   //     System.out.println(Arrays.toString(methods.doubleArray(new long[] {4, 3, 32, 5})));
    //    System.out.println(Arrays.toString(methods.multiplyItems(new long[] {4, 3, 32, 5}, 65)));
        System.out.println(Arrays.toString(methods.run(66)));

        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;
        System.out.println(row[2]); // same reference
     //   System.out.println(copy[2]);
   //     System.out.println(row[4]); // Out of bounds max [3]
    }
}
