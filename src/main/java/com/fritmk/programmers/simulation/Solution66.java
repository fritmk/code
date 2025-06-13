package com.fritmk.programmers.simulation;

import java.util.HashMap;
/**
 * 캐릭터의 좌표
 */
public class Solution66 {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        int x = 0, y = 0;

        HashMap<String, int[]> map = new HashMap<>();
        map.put("up", new int[]{0, 1});
        map.put("down", new int[]{0, -1});
        map.put("left", new int[]{-1 ,0});
        map.put("right", new int[]{1, 0});


        for(String key : keyinput) {
            int nextX = x + map.get(key)[0];
            int nextY = y + map.get(key)[1];

            if( Math.abs(nextX) <= (board[0] / 2) && Math.abs(nextY) <= (board[1] / 2)) {
                x = nextX;
                y = nextY;
            }
        }

        return new int[]{x, y};
    }
}
