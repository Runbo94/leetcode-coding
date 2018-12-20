package com.leetcode.exercise;

/**
 * Solution174
 */
public class Solution174 {

    public static void main(String[] args) {
        // input: [[1,-3,3],[0,-2,0],[-3,-3,-3]]

        int[][] input = new int[3][3];
        input[0][0] = -2;
        input[0][1] = -3;
        input[0][2] = 3;
        input[1][0] = -5;
        input[1][1] = -10;
        input[1][2] = 1;
        input[2][0] = 10;
        input[2][1] = 30;
        input[2][2] = -5;

        Solution174 solution = new Solution174();
        System.out.println(solution.calculateMinimumHP(input));

    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 1;

        int height = dungeon.length;
        int width = dungeon[0].length;

        int[][] minHP = new int[height][width];

        minHP[height - 1][width - 1] = Math.max(-dungeon[height - 1][width - 1] + 1, 1);

        for (int i = height - 2; i >= 0; i--) {
            minHP[i][width - 1] = Math.max(minHP[i + 1][width - 1] - dungeon[i][width - 1], 1);
        }

        for (int i = width - 2; i >= 0; i--) {
            minHP[height - 1][i] = Math.max(minHP[height - 1][i + 1] - dungeon[height - 1][i], 1);
        }

        for (int i = height - 2; i >= 0; i--) {
            for (int j = width - 2; j >= 0; j--) {
                minHP[i][j] = Math.max(Math.min(minHP[i + 1][j], minHP[i][j + 1]) - dungeon[i][j], 1);
            }
        }

        return minHP[0][0];
    }
}