package com.leetcode.exercise;

/**
 * Solution289
 */
public class Solution289 {
    public static void main(String[] args) {
        Solution289 solution = new Solution289();
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        solution.gameOfLife(board);

    }

    public void gameOfLife(int[][] board) {
        int length = board.length;
        int width = board[0].length;

        // state:
        // dead -> dead: 0
        // live -> live: 1
        // live -> dead: 2
        // dead -> live: 3
        int[] dx = { -1, 1, 0, 0, 1, 1, -1, -1 };
        int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int count = 0;
                // scan 8 neighbors of the node
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < length && y >= 0 && y < width && board[x][y] > 0 && board[x][y] < 3)
                        count++;
                }

                if (board[i][j] == 0) {
                    if (count == 3)
                        board[i][j] = 3; // state 3
                    else
                        board[i][j] = 0; // state 0
                } else {
                    if (count < 2 || count > 3)
                        board[i][j] = 2; // state 2
                    else
                        board[i][j] = 1; // state 1
                }

            }
        }

        // for (int i = 0; i < length; i++) {
        // for (int j = 0; j < width; j++) {
        // board[i][j] %= 2;
        // }
        // }
    }
}