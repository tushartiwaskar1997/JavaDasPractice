package org.example.practice;

import static org.example.practice.RecursionBasic.recursionBasic;
import static org.example.practice.SlidingWidow.countTheOccurrencesOfAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.stream.*;

import javax.print.DocFlavor.STRING;
import javax.print.attribute.IntegerSyntax;

public class HashMpaPractice {

    public static void findOutTheRepeatingString(String str) {

        str = " tushar kartik tushar prajwal";
        HashMap<String, Integer> map = new HashMap<>();
        String[] wordsArrays = str.split(" ");

        for (String sxu : wordsArrays) {
            map.put(sxu, map.getOrDefault(sxu, 0) + 1);
        }
        System.out.println(map + " -> map ");
        for (Entry<String, Integer> enterySet : map.entrySet()) {
            System.out.println(enterySet.getKey() + " <- key  value -> " + enterySet.getValue());
        }
    }

    public static void anagramCheckar(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch2 : str2.toCharArray()) {
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
            if (map.get(ch2) == 0)
                map.remove(ch2);
        }
        if (map.size() == 0) {
            System.out.println(" both strings are anagrams.");
        } else {
            System.out.println(" both strings are not anagrams.");
        }
    }

    public static void countCharacterFrequency(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map);
    }

    public static void findingFirstNoRepeatingCharacter(String str) {
        // this can be solved by hashmap alose but it is slow .count freq and then
        // iterate to get 1 frequency , IN linkLIstHashMap
        int[] charFrequencyArray = new int[26];
        for (Character ch : str.toCharArray()) {
            charFrequencyArray[ch - 'a']++;
        }

        for (Character ch : str.toCharArray()) {
            if (charFrequencyArray[ch - 'a'] == 1) {
                System.out.println(ch + "----> frist letter non repeated.");
            }
        }
    }

    public static void groupOfAnagrams(String[] stringArrays) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : stringArrays) {
            char[] charArrays = str.toCharArray();
            Arrays.sort(charArrays);
            String key = new String(charArrays);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);

        }
        System.out.println(map);
    }

    public static void findTheMaximunNumberOfTimesNumberRepeated(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int max = map.values().stream().max(Integer::compareTo).orElse(0);
        System.out.println(max + " ----> maximum repeated element.");
    }

    public static void removeDuplicatesFromArraysUsingLinkHashSet(int[] arr) {

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (Integer integer : arr) {
            linkedHashSet.add(integer);
        }
        System.out.println(Arrays.toString(linkedHashSet.toArray()));
    }

    public static void checkIfTokenIsBalanced(String str) {
        int[] arr = new int[26];
        for (Character ch : str.toLowerCase().toCharArray()) {
            arr[ch - 'a']++;
        }
        int count = -1;

        for (int frequency : arr) {
            if (frequency != 0) {
                if (count == -1) {
                    count = frequency;
                } else if (count != frequency) {
                    System.out.println("bad token.!");
                }
            }
        }
        System.out.println("good token.");
    }

    public static void combineStringToDistinctString(String s1, String s2) {
        TreeSet<Character> treeSet = new TreeSet<>();
        String combinedString = s1 + s2;
        for (int i = 0; i < combinedString.length(); i++) {
            treeSet.add(combinedString.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (Character character : treeSet) {
            result.append(character);
        }
        System.out.println(result + " ---> is your distinct string.");
    }

    public static String checkIfStringIsIsogram(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                System.out.println("False. IT is not an isogram.");
                return "";
            } else {
                set.add(str.charAt(i));
            }
        }
        System.out.println("True. IT is an isogram.");
        return null;
    }

    public static String checkIfStringsAreValidAnagram(String s1, String s2) {
        int[] countArr = new int[26];
        if (s1.length() != s2.length()) {
            System.out.println("String are  not anagram.");
            return null;
        }
        for (int i = 0; i < s1.length(); i++) {
            countArr[s1.charAt(i) - 'a']++;
            countArr[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (countArr[i] < 0 || countArr[i] > 0) {
                System.out.println("String are  not anagram.");
                return null;
            }
        }
        System.out.println(" String are  anagram.");
        return null;
    }

    public static void countDistinctElementInGivenWindow(int[] arr, int windowSize) {
        ArrayList<Integer> resultArray = new ArrayList<>();
        for (int i = 0; i <= arr.length - windowSize; i++) {
            resultArray.add(findDistinctElementInWindow(arr, i, i + windowSize));
        }
        System.out.println(resultArray.toString());
    }

    public static int findDistinctElementInWindow(int[] arr, int start, int end) {
        HashSet<Integer> setOfDistinctNumber = new HashSet<>();
        while (start < end) {
            setOfDistinctNumber.add(arr[start]);
            start++;
        }
        return setOfDistinctNumber.size();
    }

    public static int findFirstUniqueInteger(int[] arr) {
        LinkedHashSet<Integer> linkSet = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!linkSet.contains(arr[i])) {
                linkSet.add(arr[i]);
            } else {
                linkSet.remove(arr[i]);
            }
        }
        if (linkSet.size() != 0) {
            System.out.println("The first element is  this  --> " + linkSet.toArray()[0]);
            return 1;
        } else {
            return -1;
        }
    }

    // important
    public static void findKthMostFrequetWord(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<HashMap.Entry<String, Integer>> que = new PriorityQueue<>(
                (a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return a.getValue() - b.getValue();
                    } else {
                        return b.getKey().compareTo(a.getKey());
                    }
                });
        for (Map.Entry<String, Integer> mapw : map.entrySet()) {
            que.offer(mapw);
            if (que.size() > 2) {
                que.poll();
            }
        }
        LinkedList<String> linkedList = new LinkedList<>();
        if (!que.isEmpty()) {
            linkedList.addFirst(que.poll().getKey());
        }
        System.out.println(map);
        System.out.println(que);
        System.out.println(linkedList);
    }

    public static void findAllTheAnagramsInStringMatchingPattern(String str, String pattern) {
        // we have give the starting index of the anagram in the string.
        int[] patternFrquency = new int[26];
        for (char ch : pattern.toCharArray()) {
            patternFrquency[ch - 'a']++;
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i <= str.length() - pattern.length(); i++) {

            if (findTheAnagramIsPresentOrNotAndPassIndexOfStart(str, i, i + pattern.length(), patternFrquency)) {
                resultList.add(i);
            }
        }
        System.out.println(resultList);
    }

    public static boolean findTheAnagramIsPresentOrNotAndPassIndexOfStart(String str, int start, int end,
            int[] patternFrq) {
        System.out.println(start + " start , end " + end);
        int[] strFrequencyArr = new int[26];
        for (int i = start; i < end; i++) {
            strFrequencyArr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (patternFrq[i] != strFrequencyArr[i]) {
                return false;
            }
        }
        return true;
    }

    /// the above program is less efficeint
    public static void findAnagramAsPerPattern(String str, String pattern) {
        int[] patternFrquency = new int[26];
        int[] strFrequencyArr = new int[26];
        ArrayList<Integer> result = new ArrayList<>();
        for (char ch : pattern.toCharArray()) {
            patternFrquency[ch - 'a']++;
        }
        int window = pattern.length();
        for (int i = 0; i < window; i++) {
            strFrequencyArr[str.charAt(i) - 'a']++;
        }
        if (Arrays.equals(patternFrquency, strFrequencyArr)) {
            result.add(0);
        }

        for (int i = window; i < str.length(); i++) {
            strFrequencyArr[str.charAt(i) - 'a']++;
            strFrequencyArr[str.charAt(i - window) - 'a']--; // remove the char which are out from window.

            if (Arrays.equals(patternFrquency, strFrequencyArr)) {
                result.add(i - window + 1);
            }
        }
        System.out.println("result -> " + result);
    }

    public static void longestPalindromeNumber(String str) {
        int[] freqArr = new int[128];
        int length = 0;
        boolean hasOdd = false;

        for (char ch : str.toCharArray()) {
            freqArr[ch]++;
        }
        for (int i = 0; i < 128; i++) {
            length += (freqArr[i] / 2) * 2;
            if (freqArr[i] % 2 == 1) {
                hasOdd = true;
            }
        }
        if (hasOdd)
            length += 1;
        System.out.println("Total number of longest palindorm is  --> " + length);
        /*
         * aaabb as an example
         * a = (3/2)*2 = 1*2 =2 ;
         * b = (2/2)*2 = 1*2 =2 ;
         * total count = 2+2 =4 and one odd is their 4+1= 5;
         * Use all the even pairs you can.If you have any odd extras, use only one in
         * the center
         */
    }
}
