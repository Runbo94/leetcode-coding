package com.leetcode.exercise;

import java.util.*;

/**
 * Solution678
 */
public class Solution678 {
    public static void main(String[] args) {
        String s = ")(";
        Solution678 solution = new Solution678();
        solution.checkValidString(s);
    }

    public boolean checkValidString(String s) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                for (Integer count : set) {
                    count++;
                }
            } else if (a[i] == ')') {
                for (Integer count : set) {
                    count--;
                    if (count < 0) {
                        set.remove(count);
                    }
                }
            } else {
                Set<Integer> newSet = new HashSet<>(set);
                for (Integer count : set) {
                    Integer newCount = new Integer(count);
                    newCount--;
                    if (newCount >= 0) {
                        newSet.add(newCount);
                    }
                }
                for (Integer count : set) {
                    Integer newCount = new Integer(count);
                    newCount++;
                    newSet.add(newCount);
                }
                set = newSet;
            }
        }
        for (Integer c : set) {
            if (c == 0)
                return true;
        }
        return false;
    }
}