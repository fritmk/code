package com.fritmk.programmers.backTracking;

import java.util.ArrayList;

public class Solution45 {

    private static int[][] dungeon;
    private static int result = -1;
    private static boolean[] visited;


    private static int solution(int k, int[][] dungeons){
        dungeon = dungeons;
        visited = new boolean[dungeons.length];

        backTracking(k, 0);

        return result;
    }

    private static void backTracking(int k, int count) {

        for(int i = 0; i < dungeon.length; i++) {

            if(visited[i]) {
                if(k - dungeon[i][0] >= 0 && k - dungeon[i][1] >= 0) {
                    visited[i] = true;
                    result  = Math.min(result, count+1);
                    backTracking(k - dungeon[i][1], count+1);
                    visited[i] = false;
                }
            }


        }
    }

}
