package com.leetcode.exercise;

import java.util.*;

/**
 * Solution76
 */
public class Solution76 {
    public static void main(String[] args) {
        Solution76 solution = new Solution76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        solution.minWindow(s, t);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            hashMap.put(letter, hashMap.getOrDefault(letter, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int leftMin = 0;
        int count = 0;
        while (right < s.length()) {
            char letter = s.charAt(right);
            if (hashMap.containsKey(letter)) {
                hashMap.put(letter, hashMap.get(letter) - 1);
                if (hashMap.get(letter) == 0) {
                    count++;
                    if (count == hashMap.keySet().size()) {
                        min = Math.min(min, right - left + 1);
                        if (min == right - left + 1)
                            leftMin = left;
                    }
                }
                while (count == hashMap.keySet().size()) {
                    if (hashMap.containsKey(s.charAt(left))) {
                        hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) + 1);
                        if (hashMap.get(s.charAt(left)) > 0)
                            count--;
                        min = Math.min(min, right - left + 1);
                        if (min == right - left + 1)
                            leftMin = left;
                    }
                    left++;
                }
            }
            right++;
        }
        if (min == Integer.MAX_VALUE)
            return "";
        return s.substring(leftMin, leftMin + min);
    }

}