package org.example;

import org.example.practice.classB;

import java.util.ArrayList;
import java.util.HashMap;

import static org.example.practice.ArraysSorting.*;
import static org.example.practice.BitManipulation.*;
import static org.example.practice.RecursionBasic.*;
import static org.example.practice.SimpleHelloWorld.printHello;
import static org.example.practice.SlidingWidow.*;
import static org.example.practice.SomeRandomProblems.*;
import static org.example.practice.HashMpaPractice.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");
        // Recursion example call start //
        printHello();
        //System.out.println(recursionBasic(5));
        //printNto1(5);
        //countDown(6);
        //System.out.println(sumOf1stNaturalNumber(5));
        // reversePrintString("Tushar",6-1 );
        //System.out.println(checkEvenOddNumber(5)); // this can be done by division also
        //System.out.println( powerOfNumber(2,16));
        //printNTimesHello(5);
        //System.out.println(sumOfDigitsOfNumber(123131321, 0));
        //System.out.println(countDigitsInNumber(123123,0));
        // int[] a = {7, 1, 2, 3, -2, 4, 1, -1, -1, 0};
        // System.out.println(minimumElementInArray(a, 999999, 0, a.length));
        //printAllElementsOfArrays(a, 0);
        String s = "abc";
        //checkStringIsPalindromeOrNot(s,0,s.length()-1);
        // System.out.println( printReverseString(s,s.length()-1,""));
        //  System.out.println(findTheGcdOfNumber(48,18));
        // System.out.println(findLcm(12, 18));
        int[] arrayForGcd = {1, 2, 3, 4};
        // System.out.println(gcdOfArrays(arrayForGcd,0));
        // System.out.println(fibonacciNumberNth(41));
        // System.out.println(fibonacciNumberNthUsingForLopp(41));
        //printArrayInReversOrder(arrayForGcd, arrayForGcd.length - 1);
        //inPlaceReverseArray(arrayForGcd, 0, arrayForGcd.length - 1);
        //printArrayInReversOrder(arrayForGcd, arrayForGcd.length - 1);
        // System.out.println(checkIfArrayIsSorted(arrayForGcd,0));
        //System.out.println(checkIfArrayIsSorted(arrayForGcd,0));
        //System.out.println(binarySearchUsingRecursion(arrayForGcd,199,0,arrayForGcd.length-1));
        //printAllSubStringOfString(s,0,"");
        //printBinaryStringOfN(6,"8");
        printAllPossibleCombinationOfString(s, "");
        Hanoi(3, 'A', 'C', 'B');
        ArrayList<String> output = new ArrayList<>();
        findPathsInMaze(0, 0, 3, 3, "", output);
        /// ////////////////////////////////////////////////////////////////////////////////
//        int[][] maze = {
//                {1, 0, 0},
//                {1, 1, 0},
//                {0, 1, 1}};
//
//        int n = maze.length;
//        int m = maze[0].length;
//        boolean[][] visited = new boolean[n][m];
//        List<String> paths = new ArrayList<>();
//        if (maze[0][0] == 1) {
//            //visited[0][0] = true;  // ✅ Mark starting cell before recursion
//            findPathWithObstaclesAndBackTracking(maze, visited, 0, 0, n, m, "", paths);
//        }
        ////////////////////////////////////////////////////////////////////////////////////
//        int[] palindormeArray = {1, 2, 3, 1, 6};
//        System.out.println(checkIfArrayIsPalindromeOrNot(palindormeArray, 0, palindormeArray.length - 1));
//        findMaximumElementInArray(palindormeArray, 0, 0);

        // -------------------------Recursion end -------------------------------------- //


        // ------------------------Bit Manipulation star ----------------------------------//

        //System.out.println(testBitManipulationXor(5));
        //System.out.println(testBitManipulation(5));
        //System.out.println(evenOddNumber(3));
        //multiplyBy2(5);
        //divideBy2(4);
        //SetIthBitTo1(1, 2);  //second bit var 1 one add kay la
        // 0001 0010 0011 0100 0101 0110 0111 1000 1001 1010 1011 1100 1101 1110 1111
        //  1     2    3    4    5    6    7    8    9    10   11  12    13   14   15
        //clearIthBit(5,2);
        //toggleTheIthBit(5,1);  //if 1 will be present then it will get to change to 0 like xor with one.
        //countTheSetBits(5);
        //System.out.println(isPowerOf2(8));
        int[] countNotRepeatingNumber = {1,2,4,4,5,1,2};
        //System.out.println(nonRepeatingNumberInArray(countNotRepeatingNumber));
        //System.out.println(checkIfIthBitIs1(5 ,1));
        //checkIfNumberIsPowerOfTwo(3);
        // swapTwoNumbers(-0,-22);
        //performDivision(10,3);
        int[] repeatingArray= {1,2,3,2,1,4};
        //findOutNonRepeatingtwoNumbers(repeatingArray);
        // ------------------------Bit Manipulation end ----------------------------------//
        // ------------------------Array sorting ----------------------------------//
        int[] bubbleSort = {1, 3, 4, 2, 10, 11, 23, 0, 5, 15, 14, 5, 74, 56, 45, 8};
        // arrayBubbleSort(bubbleSort);
        // selectionSort(bubbleSort);
        //insertionSort(bubbleSort);
        //insertionSort1(bubbleSort);
        //addTwoNumberS(10,1);
        //addOneToTheNumber(10);


        // ------------------------Array sorting end ----------------------------------//

        // ------------------------Random problems  ----------------------------------//
        //findPrimeFactorsOfN(3);
        // ------------------------Random problems end ----------------------------------//

        // -----------------sliding window ---------------------------------------------//
        int[] slidingWindow = {2, 1, 5, 1, 3, 2};
      //  findTheMaxSumFromGroupOfK(slidingWindow,3);
        findLengthOfLongestSubStringNonRepeatingChar("network");
        int[] arrayWithNegativenumber ={12, -1, -7, 8, -15, 30, 16, 28};
        findTheListOfNegativeNumbersInWindowOfK(arrayWithNegativenumber,3);
        findTheListOfNegativeNumbersInWindowOfKUsingDque(arrayWithNegativenumber,3);
        int[] arraysForMaxElementInArrays = {1,3,-1,-3,5,3,6,7};
        findTheMaximumElementFromWindow(arraysForMaxElementInArrays,3);
        findTheMaximumNumberOfVowelsInArrays("abciiidef",3);
        int[] arrayForAverage = {1, 12, -5, -6, 50, 3};
        checkIfAnySubArraysHasAverageOFGivenNumber(arrayForAverage,4,12);
        int[] arraysForDistinctElements = {1, 2, 1, 3, 4};
        getSubArraysWithDistinctElementS(arraysForDistinctElements,3);
        int[] minimumSUmFromWindow = {2, 3, 1, 4, 6, 5};
        getTheMinimumSumSubArrays(minimumSUmFromWindow,3);
        countTheOccurrencesOfAnagrams("forxxorfxdofr","for");
        int[] kthClosetn = {1,2,3,4,5};
        findKthCloseElement(kthClosetn,4,3);
        findTheWindowWithoutRepeatingCharacter("abcabcbb");
        forGivenSumFindMinimumWindow(new int[]{2,3,1,2,4,3},7);
        longestSubStringWithKthDistinctElement("eceba",2);
        replaceCharacterToMakeIdenticalSubString("AABABBA",1);
        classB n =  new classB();
        int[] maxMin = {-8,-3,-10,-32,-1};
        findTheMaximnumAndMin(maxMin);
        reverseAnArraysInPlace(maxMin);
        rotateTheArrayInPlaceAtKthPosition(maxMin,2);
        findOutTheRepeatingString("adf");
        anagramCheckar("tushar","hartuss");
        countCharacterFrequency("aadfasfsf");
        findingFirstNoRepeatingCharacter("aabb");
        String[] StringArrayForAnagraps = {"eat","tea","tan","ate","nat","bat"};
        groupOfAnagrams(StringArrayForAnagraps);
        Runnable r =  ()-> {
            System.out.println("this is testing of lambda.");
        };
        r.run();
                HashMap<String, Integer> wordCount = new HashMap<>();

    }
}