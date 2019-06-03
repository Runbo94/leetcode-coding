package com.leetcode.exercise;

import java.util.*;

/**
 * Solution722
 */
public class Solution722 {
    public static void main(String[] args) {
        Solution722 solution = new Solution722();
        String[] source = { "struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};" };
        solution.removeComments(source);
    }

    public List<String> removeComments(String[] source) {
        int length = source.length;
        int pointer = 0;
        List<String> result = new ArrayList<>();
        while (pointer < length) {
            String line = source[pointer];
            if (line.contains("//")) {
                int index = line.indexOf("//");
                if (index > 0) {
                    result.add(line.substring(0, index));
                }
                pointer++;
            } else if (line.contains("/*")) {

                int index1 = line.indexOf("/*");
                String firstLine = line;
                line = line.replaceFirst("/\\*", "--");
                while (!line.contains("*/")) {
                    pointer++;
                    line = source[pointer];
                }
                StringBuilder sb = new StringBuilder();

                int index2 = line.indexOf("*/");
                if (index1 > 0) {
                    sb.append(firstLine.substring(0, index1));
                }
                if (index2 + 2 < line.length()) {
                    sb.append(line.substring(index2 + 2, line.length()));
                }
                if (sb.length() > 0) {
                    result.add(sb.toString());
                }
                pointer++;
            } else {
                result.add(line);
                pointer++;
            }
        }
        return result;
    }

}