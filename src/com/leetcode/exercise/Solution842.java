package com.leetcode.exercise;

import java.util.*;

/**
 * Solution842
 */
public class Solution842 {
    public static void main(String[] args) {
        String S = "123456579";
        Solution842 solution = new Solution842();
        solution.splitIntoFibonacci(S);
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> solution = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        dfs(S, 0, solution, result);
        return result;
    }

    public void dfs(String S, int start, List<Integer> solution, List<Integer> result) {
        if (result.size() >= 3)
            return;
        int length = S.length();
        if (start == length && solution.size() >= 3) {
            result = new LinkedList<>(solution);
            return;
        }
        if (start == length)
            return;
        if (S.charAt(start) == '0')
            return;
        if (solution.size() < 2) {
            for (int end = start + 1; end <= length; end++) {
                String sub = S.substring(start, end);
                long num = Long.valueOf(sub);
                if (num > Integer.MAX_VALUE)
                    break;
                solution.add(Integer.valueOf(sub));
                dfs(S, end, solution, result);
                solution.remove(solution.size() - 1);
            }
        } else {
            for (int end = start + 1; end <= length; end++) {
                String sub = S.substring(start, end);
                long num = Long.valueOf(sub);
                if (num > Integer.MAX_VALUE)
                    break;
                int n = Integer.valueOf(sub);
                if (n == solution.get(solution.size() - 1) + solution.get(solution.size() - 2)) {
                    solution.add(n);
                    dfs(S, end, solution, result);
                    solution.remove(solution.size() - 1);
                }
            }
        }
    }

}