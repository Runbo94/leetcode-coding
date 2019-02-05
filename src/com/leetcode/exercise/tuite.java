package com.leetcode.exercise;

import java.io.*;
import java.util.*;

public class tuite {
    // If you need extra classes, you can define them privately here within class
    // Solution

    static void parseConfiguration(List<String> configurationLines) {
        TreeMap<String, Map<String, String>> sortedMap = new TreeMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        int i = 0;
        while (i < configurationLines.size()) {
            if (configurationLines.get(i).length() == 0)
                i++;
            String childParenPair = configurationLines.get(i);
            childParenPair = childParenPair.substring(1, childParenPair.length() - 1);
            String[] pair = childParenPair.split(":");
            //
            if (pair.length > 1) {
                map2.put(pair[0], pair[1]);
            }
            i++;

            String currentServer = pair[0];
            sortedMap.put(currentServer, new HashMap<>());
            while (i < configurationLines.size() && configurationLines.get(i).length() != 0) {
                String attr = configurationLines.get(i);
                String attrKey = attr.split(" = ")[0];
                String attrVal = attr.split(" = ")[1];
                sortedMap.get(currentServer).put(attrKey, attrVal);
                i++;
            }
        }

        for (String server : sortedMap.keySet()) {
            LinkedList<String> stack = new LinkedList<>();
            Map<String, String> currentAttrs = sortedMap.get(server);

            String serverLink = server;
            stack.push(server);
            while (map2.containsKey(serverLink)) {
                serverLink = map2.get(serverLink);
                stack.push(serverLink);

                while (!stack.isEmpty()) {
                    String newServer = stack.pop();
                    Map<String, String> newAttrs = sortedMap.get(newServer);
                    for (Map.Entry<String, String> entry : newAttrs.entrySet()) {
                        currentAttrs.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }

    }

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();
        input.add("[staging_server:base_server]");
        input.add("ram = 8G");
        input.add("envname = Staging");
        input.add("");
        input.add("[dev_server:staging_server]");
        input.add("envname = Dev");
        input.add("");
        input.add("[test_server:dev_server]");
        input.add("disk = 4G");
        input.add("");
        input.add("[base_server]");
        input.add("ram = 16G");
        input.add("disk = 15G");
        input.add("");
        input.add("[qa_server:base_server]");
        input.add("ram = 4G");

        // parseConfiguration(input);
        String demo = "ram = 1";
        String demo1 = "server1:server2";
        String demo2 = "server3";
        String[] demoarray = demo.split(" = ");
        String[] demoarray1 = demo1.split(":");
        String[] demoarray2 = demo2.split(":");

        System.out.println(demoarray.toString());
    }
}