package com.fritmk.programmers;

import java.util.ArrayList;
/**
 * 깊이 우선 탐색 순회
 */
public class Solution34 {

    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static ArrayList<Integer> answer;

    public int[] solution(int[][] graph, int start, int n) {


        adjList = new ArrayList[n+1];
        visited = new boolean[n+1];
        answer = new ArrayList<>();

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void dfs(int node) {

        answer.add(node);
        visited[node] = true;

        ArrayList<Integer> nextNodes = adjList[node];
        for(int i = 0; i < nextNodes.size(); i++) {
            if(!visited[nextNodes.get(i)]) {
                dfs(nextNodes.get(i));
            }
        }

    }
}
