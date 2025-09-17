package org.example.practice;

import static org.example.practice.SlidingWidow.countTheOccurrencesOfAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.*;

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
}
