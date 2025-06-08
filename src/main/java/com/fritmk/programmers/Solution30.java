package com.fritmk.programmers;

import java.util.ArrayList;

/**
 * 간단한 유니온-파인드 알고리즘 구현하기
 * 문제 유형: 집합
 */
public class Solution30 {

    private static int[] set;


    public static void main(String[] args) {
        int k = 4;
        int[][] operation = {
                {0,0,1},
                {1,1,2},
                {0,1,2},
                {1,0,2}
        };

        Boolean[] result = solution(k, operation);
        for(Boolean r : result) {
            System.out.println(r);
        }

    }

    public static Boolean[] solution(int k, int[][] operation) {

        set = new int[k];

        // 초기화
        for(int i = 0; i < k; i++) {
            set[i] = i;
        }

        ArrayList<Boolean> result = new ArrayList<>();

        for(int[] o : operation) {
            if(o[0] == 0) { // union
                union(o[1], o[2]);
            } else { // find
                result.add(findRootNode(o[1]) == findRootNode(o[2]));
            }
        }

        return result.toArray(new Boolean[0]);
    }

    public static void union(int x, int y) {
        int xRoot = findRootNode(x);
        int yRoot = findRootNode(y);
//        set[yRoot] = set[xRoot];
        if(xRoot < yRoot) {
            set[yRoot] = xRoot;
        } else {
            set[xRoot] = yRoot;
        }
    }

    public static int findRootNode(int node) {
        if (set[node] == node) {
            return node;
        }
        return findRootNode(set[node]);
    }

}