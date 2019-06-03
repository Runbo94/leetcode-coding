package com.leetcode.exercise;

import java.util.*;

/**
 * Solution556
 */
public class Solution556 {
    public static void main(String[] args) {
        int n = 12443322;
        Solution556 solution = new Solution556();
        solution.nextGreaterElement(n);
    }

    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        int length = num.length();
        int p1 = 0;
        int p2 = 0;
        for (p1 = length - 2; p1 >= 0; p1--) {
            if (num.charAt(p1) < num.charAt(p1 + 1)) {
                break;
            }
        }
        if (p1 < 0)
            return -1;
        for (p2 = p1 + 1; p2 < length; p2++) {
            if (num.charAt(p2) < num.charAt(p1)) {
                break;
            }
        }
        p2--;
        StringBuilder sb = new StringBuilder();
        sb.append(num.substring(0, p1));
        sb.append(num.charAt(p2));
        char[] array = num.substring(p1 + 1).toCharArray();
        array[p2 - p1 - 1] = num.charAt(p1);
        Arrays.sort(array);
        sb.append(array);
        long result = Long.valueOf(sb.toString());
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
}