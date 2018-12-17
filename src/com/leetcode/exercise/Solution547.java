package com.leetcode.exercise;

/**
 * @author: runbo
 * @version: 1.0
 * @since: 9/29/2018 3:55 PM
 */
public class Solution547 {
    private boolean[] visited;

    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;

        int numOfPeople = M.length;
        visited = new boolean[numOfPeople];

        int numOfGroup = 0;

        for(int i = 0; i < numOfPeople; i++) {
            if(visited[i] == false) {
                numOfGroup++;
                dfs(i, M);
            }
        }
        return numOfGroup;
    }

    private void dfs(int person, int[][] M) {
        visited[person] = true;
        for(int friend = 0; friend < M[person].length; friend++) {
            if(M[person][friend] == 1 && visited[friend] == false) {
                dfs(friend, M);
            }
        }
    }
}
