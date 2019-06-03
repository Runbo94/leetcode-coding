package com.leetcode.exercise;

import java.util.*;

/**
 * Solution444
 */
public class Solution444 {
    public static void main(String[] args) {
        int[] org = { 1, 2, 3 };
        List<List<Integer>> seqs = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(2, 3));
        Solution444 solution = new Solution444();
        solution.sequenceReconstruction(org, seqs);
    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int numNode = org.length;
        int numSeqs = seqs.size();
        if (numNode - 1 > numSeqs)
            return false;
        int[] inDegree = new int[numNode + 1];
        int index = 1;
        for (List<Integer> seq : seqs) {
            for (int neighbor : seq) {
                if (neighbor <= numNode && neighbor > 0 && neighbor != index) {
                    inDegree[neighbor]++;
                }
            }
            index++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= numNode; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        int[] ordered = new int[numNode];
        int k = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1)
                return false;
            int current = queue.poll();
            ordered[k] = current;
            k++;
            if (current - 1 < seqs.size()) {
                List<Integer> neighbors = seqs.get(current - 1);
                for (int neighbor : neighbors) {
                    if (neighbor <= numNode && neighbor > 0 && neighbor != current) {
                        inDegree[neighbor]--;
                        if (inDegree[neighbor] == 0) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < numNode; i++) {
            if (ordered[i] != org[i])
                return false;
        }

        return true;

    }

}