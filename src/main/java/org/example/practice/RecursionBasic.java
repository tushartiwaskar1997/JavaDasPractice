package org.example.practice;

import java.util.List;

public class RecursionBasic {

    public static int recursionBasic(int n) {
        if (n == 0) {    //base case
            return 1;
        } else {
            System.out.println(n + " This is current number.");
            return n * recursionBasic(n - 1);  // recursive case
        }
    }

    public static void printNto1(int n) {
        if (n == 0) return;    //base case
        printNto1(n - 1);   //recursive case
        System.out.println(n);
    }


    public static void countDown(int n) {
        // base case
        if (n == 0) return;
        //recursive case
        countDown(n - 1);
        System.out.println(n);
    }


    public static int sumOf1stNaturalNumber(int n) {
        if (n == 0) return 0; //base case
        return n + sumOf1stNaturalNumber(n - 1);  // recursive case
    }

    public static void reversePrintString(String s, int index) {
        // Tushar  to rahsuT
        if (index < 0) return;  //base case
        System.out.println(s.charAt(index));
        reversePrintString(s, index - 1); //recursive case
    }

    public static Boolean checkEvenOddNumber(int n) {
        if (n == 0) return true;  //bot are base case
        if (n == 1) return false;
        return checkEvenOddNumber(n - 2); //recursive case
    }

    public static int powerOfNumber(int number, int power) {
        if (power == 0) return 1;  //base case
        number = number * powerOfNumber(number, power - 1);  //recursive case
        return number;
    }

    public static int printNTimesHello(int n) {
        if (n <= 0) {
            System.out.println("Hello n =" + n);
            return n;
        }
        System.out.println("Hello n =" + n);
        return printNTimesHello(n - 1);
    }

    public static int sumOfDigitsOfNumber(int number, int sum) {
        if (number == 0) return sum;   //base condition
        sum = sum + number % 10;
        return sumOfDigitsOfNumber(number / 10, sum);  // recursive condition
    }

    public static int countDigitsInNumber(int number, int count) {
        if (number == 0) return count; //base condition
        count++;
        return countDigitsInNumber(number / 10, count); //recursive condition
    }

    public static int minimumElementInArray(int[] a, int minValue, int index, int lengthOfArray) {
        if (index > lengthOfArray - 1) return minValue;
        if (minValue > a[index]) {
            minValue = a[index];
        }
        index++;
        return minimumElementInArray(a, minValue, index, lengthOfArray);
    }

    public static void printAllElementsOfArrays(int[] a, int index) {
        if (index >= a.length) return;  //base condition
        System.out.println(a[index++]);
        printAllElementsOfArrays(a, index);  //recursive condition
    }

    public static void checkStringIsPalindromeOrNot(String s, int start, int end) {
        if (start > end) {  // base case
            return;
        }
        if (s.charAt(start++) != s.charAt(end--)) {
            System.out.println("not a palindrome.");
        }
        checkStringIsPalindromeOrNot(s, start, end);   //recursion case
    }

    public static String printReverseString(String s, int index, String outputString) {
        if (index < 0) return outputString;   //base condition
        outputString = outputString + s.charAt(index--);
        return printReverseString(s, index, outputString);  //recursive condition
    }

    public static int findTheGcdOfNumber(int a, int b) {
        if (b == 0) return a;   //base case
        return findTheGcdOfNumber(b, a % b);  // recursive condition
    }

    public static int findLcm(int a, int b) {
        return (a * b) / findTheGcdOfNumber(a, b);
    }

    public static int gcdOfArrays(int[] a, int index) {
        if (index == a.length - 1) return a[index];  //base condition
        return findTheGcdOfNumber(a[index], gcdOfArrays(a, index + 1));   //recursive condition
    }

    public static int fibonacciNumberNth(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fibonacciNumberNth(n - 1) + fibonacciNumberNth(n - 2);
        //in this logic after the 40 algo takes time .
    }

    public static int fibonacciNumberNthUsingForLopp(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;  // 0 1 1 2 3 5
    }


    public static void printArrayInReversOrder(int[] a, int n) {

        if (n < 0) return;     ///base condition
        System.out.println(a[n]);
        printArrayInReversOrder(a, n - 1);   //recursion condition

        /// print the array in reverse order.

    }

    public static void inPlaceReverseArray(int[] a, int start, int end) {
        if (start >= end) return;
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
        inPlaceReverseArray(a, start + 1, end - 1);
    }


    public static boolean checkIfArrayIsSorted(int[] a, int start) {
        if (start + 1 > a.length - 1) return true;   //base conditon
        if (a[start] > a[start + 1]) return false;
        return checkIfArrayIsSorted(a, start + 1);  //recursive call
    }


    public static int binarySearchUsingRecursion(int[] a, int searchElement, int start, int end) {
        if (start > end) return -1;
        int middleIndex = (start + end) / 2;
        if (a[middleIndex] > searchElement) {
            return binarySearchUsingRecursion(a, searchElement, start, middleIndex - 1);
        } else if (a[middleIndex] == searchElement) {
            return middleIndex;
        } else {
            return binarySearchUsingRecursion(a, searchElement, middleIndex + 1, end);
        }
    }

    /// we do  division of array, and it works on fully sorted array

    //* important
    public static void printAllSubStringOfString(String string, int index, String outputString) {
        if (index > string.length() - 1) {
            System.out.println(outputString);
            return;
        }
        printAllSubStringOfString(string, index + 1, outputString);   // takes the single char at time
        printAllSubStringOfString(string, index + 1, outputString + string.charAt(index));  // takes two char at a time
    }

    //* important
    public static void printBinaryStringOfN(int n, String output) {
        if (n == 0) {     //base case
            System.out.println(output);
            return;
        }
        printBinaryStringOfN(n - 1, output + 0);
        printBinaryStringOfN(n - 1, output + 1);
    }

    //* important
    public static void printAllPossibleCombinationOfString(String s, String output) {
        if (s.length() == 0) {              /// base condition
            System.out.println(output);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            String renaming = s.substring(0, i) + s.substring(i + 1);
            printAllPossibleCombinationOfString(output, renaming + currentChar);   //recursive condition
        }
    }

    //* important
    public static void Hanoi(int numberOfDisks, char source, char finalBar, char tempBar) {
        if (numberOfDisks == 1) {
            System.out.println("Move 1 disk from " + source + " to " + finalBar);
            return;
        }
        Hanoi(numberOfDisks - 1, source, tempBar, finalBar);
        System.out.println("Move " + numberOfDisks + " disk from " + source + " to " + finalBar);
        Hanoi(numberOfDisks - 1, tempBar, finalBar, source);
    }


    public static void findPathsInMaze(int row, int col, int n, int m, String paths, List<String> list) {
        if (row == n - 1 && col == m - 1) {
            list.add(paths);
            System.out.println(paths);
            return;
        }
        if (row + 1 < n) {
            findPathsInMaze(row + 1, col, n, m, paths + "D", list);
        }
        if (col + 1 < m) {
            findPathsInMaze(row, col + 1, n, m, paths + "R", list);
        }
    }

    public static void findPathWithObstaclesAndBackTracking(int[][] matrix, boolean[][] visited, int row, int col, int n, int m, String path, List<String> list) {

        if (row == n - 1 && col == m - 1) {
            list.add(path);
            System.out.println(path);
            return;
        }
        int[] rowArray = {-1, 1, 0, 0};
        int[] colArray = {0, 0, -1, 1};
        String[] dir = {"U", "D", "L", "R"};

        //now check in all the four direction
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowArray[i];
            int newCol = col + colArray[i];
            if (helperMethodToCheckPathOkOrNot(newRow, newCol, matrix, visited, n, m)) {
                findPathWithObstaclesAndBackTracking(matrix, visited, newRow, newCol, n, m, path + dir[i], list);
            }
        }
        visited[row][col] = false;


    }

    public static boolean helperMethodToCheckPathOkOrNot(int newRow, int newCol, int[][] maze, boolean[][] visited, int n, int m) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && maze[newRow][newCol] == 1 && !visited[newRow][newCol];
    }

    public static boolean checkIfArrayIsPalindromeOrNot(int[] a, int start, int end) {
        if (start > end) return true;
        if (a[start++] != a[end--])
            return false;
        return checkIfArrayIsPalindromeOrNot(a, start, end);
    }

    public static void findMaximumElementInArray(int[] a, int max ,int index){
        if(index >a.length-1){
            System.out.println(max+" Maximum element of the arrays.");
            return;
        }
        if(max<a[index]){
            max= a[index];
        }
        findMaximumElementInArray(a,max,index+1);
    }





}

