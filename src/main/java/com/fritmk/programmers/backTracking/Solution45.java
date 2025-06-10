package com.fritmk.programmers.backTracking;

import java.util.ArrayList;

public class Solution45 {

    private static int[][] dg;
    private static int N;
    private static boolean[] visited;
    private static int answer = 0;

    public int solution(int k, int[][] dungeons) {

        N = dungeons.length;
        dg = dungeons;
        visited = new boolean[N];
        backTracking(k, 0);
        return answer;

    }


    private static void backTracking(int k, int count) {

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                if(k >= dg[i][0]) {
                    visited[i] = true;
                    backTracking( k - dg[i][1], count + 1);
                    answer = Math.max(answer, count + 1);
                    visited[i] = false;
                }
            }
        }
    }



}