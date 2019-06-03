package com.leetcode.exercise;

import java.util.*;

/**
 * Solution785
 */
public class Solution785 {
    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        Solution785 solution = new Solution785();
        solution.isBipartite(graph);
    }

    private int[] colors; // 0: not colored, 1: red, -1: black

    public boolean isBipartite(int[][] graph) {
        int numNode = graph.length;
        colors = new int[numNode];

        for (int i = 0; i < numNode; i++) {
            if (colors[i] == 0 && !dfs(i, 1, graph)) {
                return false;
            }
        }

        return true;

    }

    public boolean dfs(int node, int color, int[][] graph) {
        if (colors[node] != 0 && colors[node] != color)
            return false;
        if (colors[node] != 0 && colors[node] == color)
            return true;
        if (colors[node] == 0)
            colors[node] = color;
        int[] neighbors = graph[node];
        for (int neighbor : neighbors) {
            if (!dfs(neighbor, -color, graph))
                return false;
        }
        return true;
    }
}