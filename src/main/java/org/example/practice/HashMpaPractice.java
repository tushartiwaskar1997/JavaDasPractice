package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

}
