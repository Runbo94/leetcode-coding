package com.leetcode.exercise;

import java.util.Arrays;

/**
 * Solution681
 */
public class Solution681 {
    public static void main(String[] args) {
        String time = "13:55";
        Solution681 solution = new Solution681();
        solution.nextClosestTime(time);
    }

    public String nextClosestTime(String time) {
        // time: HH:MM => {H2, H1, M2, M1}
        char[] timeDigits = time.toCharArray();
        char H2 = timeDigits[0];
        char H1 = timeDigits[1];
        char M2 = timeDigits[3];
        char M1 = timeDigits[4];

        char[] digits = new char[] { H2, H1, M2, M1 };
        Arrays.sort(digits);
        char next;
        int upperBound;

        // HH:M_, upper bound = 9
        upperBound = 9;
        next = findNext(M1, upperBound, digits);
        timeDigits[4] = next;
        if (next > M1)
            return String.valueOf(timeDigits);

        // HH:_M, upper bound = 5
        upperBound = 5;
        next = findNext(M2, upperBound, digits);
        timeDigits[3] = next;
        if (next > M2)
            return String.valueOf(timeDigits);

        // H_:MM, if H2 == '2', upperbound = 3, else upperbound = 9
        upperBound = H2 == '2' ? 3 : 9;
        next = findNext(H1, upperBound, digits);
        timeDigits[1] = next;
        if (next > H1)
            return String.valueOf(timeDigits);

        // _H:MM, upperbound = 2;
        upperBound = 2;
        next = findNext(H2, upperBound, digits);
        timeDigits[0] = next;
        return String.valueOf(timeDigits);
    }

    public char findNext(char current, int upperBound, char[] digits) {
        if (current == '0' + upperBound)
            return digits[0];

        int index = Arrays.binarySearch(digits, current) + 1;
        while (index < 4 && (digits[index] > '0' + upperBound || digits[index] == current)) {
            index++;
        }

        return index == 4 ? digits[0] : digits[index];
    }
}