package com.leetcode.exercise;

import java.util.*;

/**
 * Solution368
 */
public class Solution368 {

    public static void main(String[] args) {
        Solution368 solution = new Solution368();
        List<Integer> result = solution.largestDivisibleSubset(new int[] { 4, 8, 10, 240 });
        System.out.println(result);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        int length = nums.length;
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            dp[i] = new ArrayList<Integer>();
        }
        dp[0].add(nums[0]);
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j].size() > dp[i].size()) {
                    dp[i].clear();
                    dp[i].addAll(dp[j]);
                    // break;
                }
            }
            dp[i].add(nums[i]);
        }

        int max_length = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (dp[i].size() > max_length) {
                max_length = dp[i].size();
                result = dp[i];
            }
        }
        return result;
    }
}