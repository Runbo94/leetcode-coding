package com.leetcode.exercise;

import java.util.*;

/**
 * Solution332
 */
public class Solution332 {
    public static void main(String[] args) {
        String[][] tickets = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
        Solution332 solution = new Solution332();
        List<String> result = solution.findItinerary(tickets);
        System.out.println(result);
    }

    public List<String> findItinerary(String[][] tickets) {
        // edge test

        // ticket format: [departure, arrival]
        Map<String, List<String>> adjacents = new HashMap<>();
        int numTickets = tickets.length;

        for (String[] ticket : tickets) {
            String departure = ticket[0];
            String arrival = ticket[1];
            adjacents.putIfAbsent(departure, new LinkedList<>());
            adjacents.get(departure).add(arrival);
        }

        String departure = "JFK";
        int currentTickets = 0;
        List<String> route = new ArrayList<String>();
        dfs(departure, adjacents, currentTickets, numTickets, route);

        return route;

    }

    public void dfs(String departure, Map<String, List<String>> adjacents, int currentTickets, int numTickets,
            List<String> route) {
        if (!adjacents.containsKey(departure))
            return;

        List<String> neighbors = adjacents.get(departure);
        for (int i = 0; i < neighbors.size(); i++) {
            String neighbor = neighbors.get(i);
            neighbors.remove(i);
            currentTickets++;
            route.add(0, neighbor);
            dfs(neighbor, adjacents, currentTickets, numTickets, route);
            if (currentTickets == numTickets)
                return;
            route.remove(0);
            currentTickets--;
            neighbors.add(i, neighbor);
        }
    }

}