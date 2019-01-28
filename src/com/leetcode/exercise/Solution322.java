package com.leetcode.exercise;

/**
 * Solution322
 */
public class Solution322 {

    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 5 };
        int amount = 11;

        Solution322 s = new Solution322();
        int min_change = s.coinChange(coins, amount);
        System.out.println(min_change);

    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (coins == null || coins.length == 0)
            return -1;

        int num_of_coins = coins.length;
        int[][] dp = new int[num_of_coins + 1][amount + 1];

        // initial dp array
        dp[0][0] = 1;
        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < num_of_coins + 1; i++) {
            dp[i][0] = 0;
        }

        // dp transfer process
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 1; j < num_of_coins + 1; j++) {
                if (i - coins[j - 1] >= 0 && dp[j][i - coins[j - 1]] != Integer.MAX_VALUE)
                    dp[j][i] = Math.min(dp[j - 1][i], dp[j][i - coins[j - 1]] + 1);
                else
                    dp[j][i] = dp[j - 1][i];
            }
        }

        return dp[num_of_coins][amount] == Integer.MAX_VALUE ? -1 : dp[num_of_coins][amount];
    }
}