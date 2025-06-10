package com.fritmk.programmers.graph;

import java.util.ArrayList;

/**
 * 네트워크
 * 문제유형: 그래프(DFS)
 * 난이도: 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Solution38 {

    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            for(int j  = 0; j < n; j++) {
                if(i !=j && computers[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer += 1;
                dfs(i);

            }
        }
        return answer;
    }

    public static void dfs(int x) {

        if(visited[x]) {
            return;
        }

        visited[x] = true;
        ArrayList<Integer> nextNode = adjList[x];

        for(int i = 0; i < nextNode.size(); i++) {
            if(!visited[nextNode.get(i)]) {
                dfs(nextNode.get(i));
            }
        }

    }

    // ------


    private static int[][] computer;

    public int solution2(int n, int[][] computers) {
        int answer = 0;
        computer = computers;

        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer += 1;
                dfs2(i);
            }
        }
        return answer;
    }

    public static void dfs2(int x) {

        visited[x] = true;

        for(int i = 0; i < computer[x].length; i++) {
            if(computer[x][i] == 1 && !visited[i]) {
                dfs(i);
            }

        }
    }
}
