package com.leetcode.exercise;

import java.util.*;

/**
 * Solution227
 */
public class Solution227 {
    public static void main(String[] args) {
        String s = " 3/2 ";
        Solution227 solution = new Solution227();
        solution.calculate(s);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int first = 0;
        int second = 0;
        int sign = '+';
        int num = 0;
        while (second < s.length()) {
            char firstChar = s.charAt(first);
            if (firstChar == ' ') {
                first++;
                second++;
                continue;
            }
            if (Character.isDigit(firstChar)) {
                while (second < s.length() && Character.isDigit(s.charAt(second))) {
                    second++;
                }
                num = Integer.valueOf(s.substring(first, second));
                first = second;
            }
            if (!Character.isDigit(firstChar) || first == s.length()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = firstChar;
                first++;
                second++;
            }
        }

        int result = 0;
        for (int ele : stack) {
            result += ele;
        }
        return result;
    }
}