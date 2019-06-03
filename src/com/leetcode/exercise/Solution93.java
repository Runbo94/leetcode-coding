package com.leetcode.exercise;

import java.util.*;

/**
 * Solution93
 */
public class Solution93 {
    public static void main(String[] args) {
        String s = "0279245587303";
        Solution93 solution = new Solution93();
        solution.restoreIpAddresses(s);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<String>();
        List<String> i = new LinkedList<String>();
        dfs(s, 3, i, result);
        return result;
    }

    public void dfs(String s, int dot, List<String> interResult, List<String> result) {
        if (dot != 0 && s == "")
            return;
        if (dot == 0 && s == "")
            return;
        if (dot == 0 && Integer.valueOf(s) > 255)
            return;
        if (dot == 0 && Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 255) {
            interResult.add(s);
        }

        int length = s.length();
        for (int i = 1; i < length; i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i, length);
            int preValue = Integer.valueOf(prefix);
            if (preValue >= 0 && preValue <= 255) {
                List<String> intermedias = new LinkedList<>();
                dfs(suffix, dot - 1, intermedias, result);
                if (dot == 3) {
                    for (String intermedia : intermedias) {
                        result.add(prefix + "." + intermedia);
                    }
                } else {
                    for (String intermedia : intermedias) {
                        interResult.add(prefix + "." + intermedia);
                    }
                }

            } else if (preValue > 255) {
                break;
            }
        }
        return;
    }

}