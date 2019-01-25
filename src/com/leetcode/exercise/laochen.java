package com.leetcode.exercise;

/**
 * laochen
 */
// public class laochen {

//     public static void main(String[] args) {
//         String d = "@example.com";
//         String[] ds = d.split("\\@");
//         System.out.println(ds.toString());
//     }

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

class Solution11111 {
    public static void main(String[] args) {
        String[] input = { "unique@example.com", "uni.que@example.com", "unique+test@example.com",
                "unique@anotherexample.com" };
        Solution11111 s = new Solution11111();
        int res = s.solution(input);
        System.out.println(res);
    }

    public int solution(String[] L) {
        // write your code in Java SE 8
        if (L.length == 0) {
            return 0;
        }
        int res = 0;
        Map<String, Integer> hm = new HashMap<>();
        for (String link : L) {
            String[] elements = link.split("\\@");
            String unique = elements[0];
            String domain = elements[1];
            // deal with unique
            String[] noPlus = unique.split("\\+");
            String uniqueNoPlus = noPlus[0];
            StringBuilder uniqueSB = new StringBuilder(uniqueNoPlus);
            int index = 0;
            while (index < uniqueSB.length()) {
                if (uniqueSB.charAt(index) == '.') {
                    uniqueSB.deleteCharAt(index);
                } else {
                    index++;
                }
            }
            String uniqueLink = uniqueSB.append(domain).toString();
            int occ = 1;
            if (hm.containsKey(uniqueLink)) {
                occ = hm.get(uniqueLink) + 1;
                hm.put(uniqueLink, occ);
            }
            res = Math.max(res, occ);
        }
        return res;
    }
}
