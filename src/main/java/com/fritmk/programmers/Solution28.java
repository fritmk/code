package com.fritmk.programmers;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 양과 늑대
 * 문제 유형: 트리
 * 난이도: 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/92343
 * dfs도 맞는데... 일반적인 dfs라고 할 수 있나.. - 상태 공간을 탐색하는 DFS 백트래킹 라고 표현함.
 */
public class Solution28 {

    private static HashMap<Integer, ArrayList<Integer>> tree;
    private static int maxSheep;
    private static int[] animals;

    public static void main(String[] args) {
        System.out.println(new Solution28().solution(
                new int[]{0,0,1,1,1,0,1,0,1,0,1,1},
                new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}
        ));
    }

    public int solution(int[] info, int[][] edges) {

        //초기화
        maxSheep = 0;
        animals = info;

        tree = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            ArrayList<Integer> child = tree.getOrDefault(edge[0], new ArrayList<>());
            child.add(edge[1]);
            tree.put(edge[0], child);
        }

        // 방문해야하는 노드
        ArrayList<Integer> nextNode = new ArrayList<>(tree.get(0)); // 1, 8

        dfs(nextNode, 1, 0);


        return maxSheep;
    }

    private static void dfs(ArrayList<Integer> nextNode, int sheep, int wolf) {

        maxSheep = Math.max(sheep, maxSheep);

        for(int node : nextNode) {
            if(animals[node] == 0) { // 양일 때
                ArrayList<Integer> cloneNode = new ArrayList<>(nextNode);
                if(tree.get(node) != null && !tree.get(node).isEmpty()) {
                    cloneNode.addAll(tree.get(node));
                }
                cloneNode.remove(cloneNode.indexOf(node));
                dfs(cloneNode, sheep + 1, wolf);
            } else { // 늑대일 때
                if(sheep <= wolf + 1) {
                    continue;
                } else {
                    ArrayList<Integer> cloneNode = new ArrayList<>(nextNode);
                    if(tree.get(node) != null  && !tree.get(node).isEmpty()) {
                        cloneNode.addAll(tree.get(node));
                    }
                    cloneNode.remove(cloneNode.indexOf(node));
                    dfs(cloneNode, sheep, wolf + 1);
                }
            }
        }
    }

}
