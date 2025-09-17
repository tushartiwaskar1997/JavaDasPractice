package org.example.practice;

public class SomeRandomProblems {

    public static void findPrimeFactorsOfN(int n) {

        while (n % 2 == 0) {  // prime factor 2
            //print the number  of time  2 is used  ;
            System.out.println(2 + " ");
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {   // for odd number only
            while (n % i == 0) {
                System.out.println(i + " ");
                n /= i;
            }
        }
        if (n > 2) {
            System.out.print(n + "");
        }
    }
}
