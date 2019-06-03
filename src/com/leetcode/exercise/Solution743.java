package com.leetcode.exercise;

import java.util.*;

/**
 * Solution743
 */
public class Solution743 {
    public static void main(String[] args) {
        int[][] times = { { 1, 2, 1 }, { 2, 3, 2 }, { 1, 3, 2 } };
        int N = 3;
        int K = 1;
        Solution743 solution = new Solution743();
        solution.networkDelayTime(times, N, K);
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        // boolean[] visited = new boolean[N];
        int[] visitedTime = new int[N];
        Arrays.fill(visitedTime, Integer.MAX_VALUE);

        Queue<List<Integer>> queue = new LinkedList<>();
        /**
         * Queue: ----------------------------------------- ..., [current node, current
         * time], ... -----------------------------------------
         */

        queue.offer(Arrays.asList(K, 0));
        int currentTime;
        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int currentNode = current.get(0) - 1;
            currentTime = current.get(1);

            visitedTime[currentNode] = currentTime;
            for (int[] time : times) {
                if (time[0] - 1 == currentNode && currentTime + time[2] < visitedTime[time[1] - 1]) {
                    queue.offer(Arrays.asList(time[1], currentTime + time[2]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int vt : visitedTime) {
            max = Math.max(max, vt);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}