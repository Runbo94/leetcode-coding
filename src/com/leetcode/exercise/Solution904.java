package com.leetcode.exercise;

import java.util.*;

/**
 * Solution904
 */
public class Solution904 {
    public static void main(String[] args) {
        Solution904 solution = new Solution904();
        int[] tree = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        System.out.println(solution.totalFruit(tree));
    }

    public int totalFruit(int[] tree) {
        int length = tree.length;
        Map<Integer, Integer> numOfType = new HashMap<>();
        Set<Integer> twoBaskets = new HashSet<Integer>();

        int amount = 0;
        int maxAmount = 0;

        // initial two pointer
        int firstPointer = 0;
        int secondPointer = 0;
        while (secondPointer < length) {
            twoBaskets.add(tree[secondPointer]);
            numOfType.put(tree[secondPointer], numOfType.getOrDefault(tree[secondPointer], 0) + 1);
            if (twoBaskets.size() < 3) {
                amount++;
            } else {
                while (firstPointer <= secondPointer) {
                    numOfType.put(tree[firstPointer], numOfType.get(tree[firstPointer]) - 1);
                    if (numOfType.get(tree[firstPointer]) == 0) {
                        maxAmount = Math.max(maxAmount, amount);
                        amount = secondPointer - firstPointer;
                        twoBaskets.remove(tree[firstPointer]);
                        firstPointer++;
                        break;
                    }
                    firstPointer++;
                }
            }
            secondPointer++;
        }
        return Math.max(maxAmount, amount);
    }
}