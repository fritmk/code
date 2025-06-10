package com.fritmk.programmers.graph;

import java.sql.Array;
import java.util.ArrayList;
/**
 * 전력망을 둘로 나누기
 * 문제유형: 그래프, 완전탐색
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */
public class Solution42 {

    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) {
        int z = solution(4, new int[][]{{1,2}, {2,3}, {3,4}});
        System.out.println(z);
    }

    public static int  solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        adjList = new ArrayList[n+1];
        for(int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        //
        for (int[] removeWire : wires) {

            visited = new boolean[n+1]; // 초기화
            int result = dfs(removeWire[0], removeWire);
            int result2 = n - result;
            answer= Math.min(answer, Math.abs(result -result2));
        }
        return answer;

    }


    public static int dfs(int x, int[] removeWire) {

        visited[x] = true;
        int count = 1;

        ArrayList<Integer> nextNode = adjList[x];
        for(int i = 0; i < nextNode.size(); i++) {

            if(x == removeWire[0] && nextNode.get(i) == removeWire[1]) {
               continue;
            }
            if(x == removeWire[1] && nextNode.get(i) == removeWire[0]) {
                continue;
            }

            if(!visited[nextNode.get(i)]) {
                count += dfs(nextNode.get(i), removeWire);
            }
        }
        return count;

    }
}


