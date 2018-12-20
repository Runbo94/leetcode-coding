package com.leetcode.exercise;

import java.util.*;

/**
 * Solution120
 */
public class Solution120 {

    public static void main(String[] args) {
        ArrayList<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(new Integer[] { 2 }));
        input.add(Arrays.asList(new Integer[] { 3, 4 }));
        input.add(Arrays.asList(new Integer[] { 6, 5, 7 }));
        input.add(Arrays.asList(new Integer[] { 4, 1, 8, 3 }));

        Solution120 solution = new Solution120();
        System.out.println(solution.minimumTotal(input));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
            return Integer.MAX_VALUE;

        int height = triangle.size();
        int width = triangle.get(height - 1).size();

        int[][] dp = new int[height][width];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }

        int minimum_path_sum = Integer.MAX_VALUE;
        for (int i = 0; i < width; i++) {
            minimum_path_sum = Math.min(minimum_path_sum, dp[height - 1][i]);
        }
        return minimum_path_sum;
    }

}