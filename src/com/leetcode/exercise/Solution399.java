package com.leetcode.exercise;

import java.util.*;

class Solution399 {
    public static void main(String[] args) {
        String[][] equations = { { "a", "b" }, { "b", "c" } };
        double[] values = { 2.0, 3.0 };
        String[][] queries = { { "a", "c" }, { "b", "c" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };

        // String[][] equations = { { "x1", "x2" }, { "x2", "x3" }, { "x3", "x4" }, {
        // "x4", "x5" } };
        // double[] values = { 3.0, 4.0, 5, 6 };
        // String[][] queries = { { "x5", "x2" } };
        Solution399 solution = new Solution399();
        System.out.println(solution.calcEquation(equations, values, queries));
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> hash = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        int length = equations.length;

        for (int i = 0; i < length; i++) {
            String dividend = equations[i][0];
            String divisor = equations[i][1];
            double divideResult = values[i];
            visited.put(dividend, false);
            visited.put(divisor, false);

            if (hash.containsKey(dividend)) {
                hash.get(dividend).put(divisor, divideResult);
            } else {
                HashMap<String, Double> tmp = new HashMap<>();
                tmp.put(divisor, divideResult);
                hash.put(dividend, tmp);
            }

            if (divideResult != 0) {
                if (hash.containsKey(divisor)) {
                    hash.get(divisor).put(dividend, 1 / divideResult);
                } else {
                    HashMap<String, Double> tmp = new HashMap<>();
                    tmp.put(dividend, 1 / divideResult);
                    hash.put(divisor, tmp);
                }
            }
        }

        // loop over the queries
        int queriesLength = queries.length;
        double[] queriesResult = new double[queriesLength];
        for (int i = 0; i < queriesLength; i++) {
            String wantedDividend = queries[i][0];
            String wantedDivisor = queries[i][1];
            double wantedResult = getDivision(hash, visited, wantedDividend, wantedDivisor, 1);
            queriesResult[i] = wantedResult;
        }

        return queriesResult;
    }

    public double getDivision(HashMap<String, HashMap<String, Double>> hash, HashMap<String, Boolean> visited,
            String dividend, String divisor, double eval) {
        if (!hash.containsKey(dividend))
            return -1;
        if (dividend.equals(divisor))
            return eval;
        HashMap<String, Double> tmp = hash.get(dividend);
        double result = -1;
        for (Map.Entry<String, Double> divisorAndRes : tmp.entrySet()) {
            String nextDividend = divisorAndRes.getKey();
            double currentResult = divisorAndRes.getValue();
            if (!visited.get(nextDividend)) {
                visited.put(nextDividend, true);
                result = getDivision(hash, visited, nextDividend, divisor, currentResult * eval);
                if (result != -1)
                    return result;
                visited.put(nextDividend, false);
            }
        }

        return result;

    }
}