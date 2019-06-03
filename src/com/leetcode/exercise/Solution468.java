package com.leetcode.exercise;

/**
 * Solution468
 */
public class Solution468 {
    public static void main(String[] args) {
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        Solution468 solution = new Solution468();
        solution.validIPAddress(IP);
    }

    public String validIPAddress(String IP) {
        IP = IP.replace(":", ".");
        // System.out.println(IP);
        String[] sections = IP.split("\\.");
        int length = sections.length;
        // System.out.println(Arrays.toString(sections));
        if (length != 4 || length != 8)
            return "Neither";
        if (length == 4) {
            for (int i = 0; i < length; i++) {
                String section = sections[i];
                if (section.length() > 3)
                    return "Neither";
                for (int j = 0; j < section.length(); j++) {
                    if (!Character.isDigit(section.charAt(j)))
                        return "Neither";
                }
                int num = Integer.valueOf(section);
                // System.out.println(num);
                if (num < 0 || num > 255)
                    return "Neither";
            }
            return "IPv4";
        } else if (length == 8) {
            for (int i = 0; i < length; i++) {
                String section = sections[i];
                if (section.length() > 4 || section.length() == 0)
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
}