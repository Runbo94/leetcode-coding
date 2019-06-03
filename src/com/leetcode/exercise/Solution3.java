package com.leetcode.exercise;

import java.util.*;

/**
 * Solution3
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "abba";
        Solution3 solution = new Solution3();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int current = 0;
        int first = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                // max = Math.max(max, i - map.get(s.charAt(i)));
                first = Math.max(first, map.get(s.charAt(i)) + 1);
            }

            current = i - first + 1;
            map.put(s.charAt(i), i);
            max = Math.max(max, current);
        }

        return max;
    }
}