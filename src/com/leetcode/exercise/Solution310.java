package com.leetcode.exercise;

import java.util.*;

/**
 * Solution310
 */
public class Solution310 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        Solution310 solution = new Solution310();
        List<Integer> list = solution.findMinHeightTrees(n, edges);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // store the heights from each node
        int[] heights = new int[n];
        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int height = bfs(n, edges, i);
            heights[i] = height;
            minHeight = Math.min(minHeight, height);
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (heights[i] == minHeight) {
                result.add(i);
            }
        }
        return result;
    }

    public int bfs(int n, int[][] edges, int start) {
        // level number
        int count = 0;

        // queue is used for bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        // store the heights from start to i
        int[] heights = new int[n];
        Arrays.fill(heights, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                heights[current] = count;
                for (int[] edge : edges) {
                    int from = edge[0];
                    int to = edge[1];
                    if (from == current) {
                        queue.offer(to);
                    }
                }
            }
            count++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i]);
        }
        return max;
    }

}