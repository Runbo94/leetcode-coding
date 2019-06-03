package com.leetcode.exercise;

import java.util.*;

/**
 * Solution929
 */
public class Solution929 {

    public static void main(String[] args) {
        String[] emails = { "fg.r.u.uzj+o.pw@kziczvh.com", "r.cyo.g+d.h+b.ja@tgsg.z.com",
                "fg.r.u.uzj+o.f.d@kziczvh.com", "r.cyo.g+ng.r.iq@tgsg.z.com", "fg.r.u.uzj+lp.k@kziczvh.com",
                "r.cyo.g+n.h.e+n.g@tgsg.z.com", "fg.r.u.uzj+k+p.j@kziczvh.com", "fg.r.u.uzj+w.y+b@kziczvh.com",
                "r.cyo.g+x+d.c+f.t@tgsg.z.com", "r.cyo.g+x+t.y.l.i@tgsg.z.com", "r.cyo.g+brxxi@tgsg.z.com",
                "r.cyo.g+z+dr.k.u@tgsg.z.com", "r.cyo.g+d+l.c.n+g@tgsg.z.com", "fg.r.u.uzj+vq.o@kziczvh.com",
                "fg.r.u.uzj+uzq@kziczvh.com", "fg.r.u.uzj+mvz@kziczvh.com", "fg.r.u.uzj+taj@kziczvh.com",
                "fg.r.u.uzj+fek@kziczvh.com" };
        Solution929 solution = new Solution929();
        int result = solution.numUniqueEmails(emails);
    }

    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> hashMap = new HashMap<>();
        // get local address
        for (String email : emails) {
            String local = email.split("@")[0];
            String host = email.split("@")[1];

            String simplified = simplifyLocalName(local);
            email = simplified + "@" + host;
            hashMap.put(email, hashMap.getOrDefault(email, 0) + 1);
        }

        // find
        int max = Integer.MIN_VALUE;
        for (int value : hashMap.values()) {
            max = Math.max(max, value);
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public String simplifyLocalName(String localName) {
        // remove dot
        String nameWithoutDot = String.join("", localName.split("\\."));

        // remove addition operator and everything after that
        String result = nameWithoutDot.split("\\+")[0];

        return result;
    }
}