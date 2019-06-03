package com.leetcode.exercise;

import java.util.*;

/**
 * Solution696
 */
public class Solution696 {
    public static void main(String[] args) {
        String s = "00110";
        Solution696 solution = new Solution696();
        solution.countBinarySubstrings(s);
    }

    public int countBinarySubstrings(String s) {
        char[] sa = s.toCharArray();
        int length = sa.length;

        int[] consecutive = new int[length];
        consecutive[0] = 1;
        for (int i = 1; i < length; i++) {
            if (sa[i] == sa[i - 1]) {
                consecutive[i] = consecutive[i - 1];
            } else {
                consecutive[i] = consecutive[i - 1] + 1;
            }
        }

        int[] numOne = new int[length + 1];
        numOne[0] = 0;
        for (int i = 1; i <= length; i++) {
            if (sa[i - 1] == '1') {
                numOne[i] = numOne[i - 1] + 1;
            } else {
                numOne[i] = numOne[i - 1];
            }
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int numOf1 = numOne[j + 1] - numOne[i];
                int c = consecutive[j] - consecutive[i];
                if (numOf1 == j - i + 1 && c == 1)
                    result++;
            }
        }
        return result;

    }

}