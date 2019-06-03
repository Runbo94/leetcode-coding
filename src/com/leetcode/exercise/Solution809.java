package com.leetcode.exercise;

import java.util.*;

/**
 * Solution809
 */
public class Solution809 {
    public static void main(String[] args) {
        String S = "zzzzzyyyyy";
        String[] words = { "zzyy", "zy", "zyy" };
        Solution809 solution = new Solution809();
        solution.expressiveWords(S, words);
    }

    public int expressiveWords(String S, String[] words) {
        int result = 0;

        for (String word : words) {
            if (check(word, S))
                result++;
        }
        return result;
    }

    public boolean check(String shorter, String longer) {
        if (shorter == null || longer == null)
            return false;
        int slen = shorter.length();
        int llen = longer.length();
        int sp = 0;
        int lp = 0;
        while (lp < llen) {
            if (sp < slen && shorter.charAt(sp) == longer.charAt(lp)) {
                sp++;
                lp++;
            } else if (lp - 2 > 0 && longer.charAt(lp) == longer.charAt(lp - 1)
                    && longer.charAt(lp) == longer.charAt(lp - 2)) {
                lp++;
            } else if (lp - 1 > 0 && lp + 1 < llen && longer.charAt(lp) == longer.charAt(lp + 1)
                    && longer.charAt(lp) == longer.charAt(lp - 1)) {
                lp++;
            } else {
                break;
            }
        }
        return lp == llen;
    }

}