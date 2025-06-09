package com.fritmk.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 너비 우선 탕색 순회
 */
public class Solution35 {


    public int[] solution (int[][] graph, int start, int n) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer>[] adjList = new ArrayList[n+1];

        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }



        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];

        visited[start] = true;
        queue.add(start);
        result.add(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);
            ArrayList<Integer> nextNodes = adjList[now];
            for(int i = 0; i < nextNodes.size(); i++) {
                if(!visited[nextNodes.get(i)]) {
                    queue.add(nextNodes.get(i));
                    visited[nextNodes.get(i)] = true;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }

}
