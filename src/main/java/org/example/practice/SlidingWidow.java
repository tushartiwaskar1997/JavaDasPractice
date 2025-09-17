package org.example.practice;

import java.util.*;

public class SlidingWidow {


    public static void findTheMaxSumFromGroupOfK(int[] a, int k) {
        int maxSum = 0;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += a[i];
        }

        for (int i = k; i < a.length; i++) {
            windowSum = windowSum + a[i] - a[i - k];
            maxSum = Math.max(windowSum, maxSum);
        }
        System.out.println(maxSum + " <- THis the the max sum of arrays in window of k.");
    }

    public static void findLengthOfLongestSubStringNonRepeatingChar(String s) {
        ///  non repeating character.
        //str= abcabcbb

        int right = 0;
        int left = 0;
        int maxSize = 0;
        HashSet<String> set = new HashSet<>();
        while (right < s.length()) {
            if (left <= s.length() - 1 && !set.contains(s.charAt(left) + "")) {
                set.add(s.charAt(left) + "");
                left++;
            } else {
                right = left;
                maxSize = Math.max(maxSize, set.size());
                set.clear();
            }
        }
        System.out.println("Length of the string s -> " + s.length());
        System.out.println(maxSize);
    }


    public static void findTheListOfNegativeNumbersInWindowOfK(int[] a, int k) {

        int right = 0;
        int left = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (right = 0; right <= a.length - k; right++) {
            boolean isNumberFound = false;
            for (left = 0; left < k; left++) {
                if (a[right + left] < 0) {
                    result.add(a[right + left]);
                    isNumberFound = true;
                    break;
                }
            }
            if (!isNumberFound) {
                result.add(0);
            }
        }
        System.out.println(result);
    }


    //* important (fast aproche)
    public static void findTheListOfNegativeNumbersInWindowOfKUsingDque(int[] a, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        // in dq we store the negative numbres
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                dq.add(i);
            }
        }
        for (int i = k; i < a.length - k; i++) {
            if (!dq.isEmpty()) {
                result.add(a[dq.peekFirst()]);   //  get first element. and add it to the result.
            } else {
                result.add(0);
            }

            while (!dq.isEmpty() & dq.peekFirst() <= i - k) {  // if first element is out of the window  removee it.
                dq.pollFirst();
            }

            if (a[i] < 0) {               // // add the index to ques if number is negative.
                dq.add(i);
            }
        }
        // Handle the last window
        if (!dq.isEmpty()) {
            result.add(a[dq.peekFirst()]);
        } else {
            result.add(0);
        }
        System.out.println(dq);
        System.out.println(result);
    }

    public static void findTheMaximumElementFromWindow(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= a.length - k; i++) {
            int maxElement = 0;
            for (int j = 0; j < k; j++) {
                maxElement = Math.max(maxElement, a[i + j]);
            }
            list.add(maxElement);
        }
        System.out.println(list);
    }

    public static void findTheMaximumNumberOfVowelsInArrays(String string, int k) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int maxfinal = 0;
        for (int i = 0; i < string.length() - k; i++) {
            int maxtemp = 0;
            for (int j = 0; j < k; j++) {
                if (set.contains(string.charAt(i + j))) {
                    maxtemp += 1;
                }
            }
            maxfinal = Math.max(maxfinal, maxtemp);
        }
        System.out.println(maxfinal + " max length of vovels is this.");
    }

    public static void checkIfAnySubArraysHasAverageOFGivenNumber(int[] a, int k, int average) {
        List<Integer> resultlist = new ArrayList<>();
        for (int i = 0; i < a.length - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += a[i + j];
                resultlist.add(a[i + j]);
            }
            if (!((sum / k) >= average)) {
                resultlist.clear();
            }
        }
        System.out.println(resultlist + " this is the array with average of equal or grater to 12.");
    }

    public static void getSubArraysWithDistinctElementS(int[] a, int k) {
        List<List<Integer>> finalList = new ArrayList<>();
        for (int i = 0; i <= a.length - k; i++) {
            List<Integer> temList = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                if (temList.isEmpty()) {
                    temList.add(a[i + j]);
                } else if (!temList.isEmpty() && !temList.contains(a[i + j])) {
                    temList.add(a[i + j]);
                }
            }
            if (temList.size() == k) {
                finalList.add(temList);
            }
        }
        System.out.println(finalList + "final List of elements.");
    }

    public static void getTheMinimumSumSubArrays(int[] a, int k) {
        if (k < 0) {
            System.out.println(-1 + " ");
        }
        int miniSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += a[i];
        }
        miniSum = windowSum;
        for (int j = k; j < a.length; j++) {
            windowSum += a[j] - a[j - k];
            miniSum = Math.min(windowSum, miniSum);
        }
        System.out.println(miniSum + " minimum sum with window size");
    }

    //*  important
    public static void countTheOccurrencesOfAnagrams(String string, String path) {
        int[] pathChars = new int[26];
        int[] windowFeq = new int[26];
        int k = path.length();
        int count = 0;

        // we nee to count the frequency  of the
        for (char character : path.toCharArray()) {
            pathChars[character - 'a']++;
        }


        for (int i = 0; i < string.length(); i++) {
            windowFeq[string.charAt(i) - 'a']++;

            if (i >= k) {
                windowFeq[string.charAt(i - k) - 'a']--;     /// as window moves checks for the frequency
            }
            if (i >= k - 1 && Arrays.equals(pathChars, windowFeq)) {  // i >= k-1 is used so that it is used to check if windo is form or not
                count++;
            }
        }
        System.out.println(count + " number of anagram");
    }

    public static void findKthCloseElement(int[] a, int k, int x) {

        int left = 0;
        int right = a.length - 1;

        while ((right - left) >= k) {

            if (Math.abs(a[left] - x) > Math.abs(a[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(a[i]);
        }
        System.out.println(result + " the result of k the closet.");
    }


    public static void findTheWindowWithoutRepeatingCharacter(String string) {

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLengthOfString = 0;
        int start = 0;
        for (int end = 0; end < string.length(); end++) {
            if (map.containsKey(string.charAt(end)) && map.get(string.charAt(end)) >= start) {
                // if a is found again then change the start position.
                start = map.get(string.charAt(end)) + 1;  //new start position
            }
            map.put(string.charAt(end), end);
            maxLengthOfString = Math.max(maxLengthOfString, end - start + 1);
        }
        System.out.println(map);
        System.out.println("max length of the string is non repeating char -> " + maxLengthOfString);
    }

    public static void forGivenSumFindMinimumWindow(int[] a, int target) {
        int minMumSizeSibArray = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < a.length; right++) {
            currentSum += a[right];

            while (currentSum >= target) {
                minMumSizeSibArray = Math.min(minMumSizeSibArray, right - left + 1);
                currentSum -= a[left];  // remove the previous added  number and move front.
                left++;
            }
        }
        System.out.println(minMumSizeSibArray + "- > minimum size of the array. ");
    }

    public static void longestSubStringWithKthDistinctElement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int minLength = 0;
        if (s == null || k == 0) System.out.println(0 + "No value");

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            minLength = Math.max(minLength, right - left + 1);
        }
        System.out.println(minLength + " <- THe maxumn leng for k dist elements  -> " + map);
    }

    public static void replaceCharacterToMakeIdenticalSubString(String s, int k) {
        int[] count =  new int[28];
        int maxFreq = 0;
        int left = 0 ,maxLen = 0;

        for(int right = 0 ; right< s.length() ; right++){
            count[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq , count[s.charAt(right)-'A']);
            while ((right-left+1) -maxFreq>k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        System.out.println(maxLen + "- >  max length.");
    }
}

