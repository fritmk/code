package com.fritmk.programmers;

import java.util.HashSet;
import java.util.HashMap;
/**
 * 방문 길이
 */
public class Solution7 {


    public boolean check(int nx, int ny) {
        return nx >= -5 && nx <= 5 && ny <= 5 && ny >= -5;
    }

    public int solution(String dirs) {


        HashMap<String, int[]> control = new HashMap<>();
        control.put("U", new int[]{0, 1});
        control.put("D", new int[]{0, -1});
        control.put("L", new int[]{-1, 0});
        control.put("R", new int[]{1, 0});

        int x = 0;
        int y = 0;

        HashSet<String> history  = new HashSet<>();

        for(int i = 0; i < dirs.length(); i++ ){
            String dir = String.valueOf(dirs.charAt(i));

            int[] next = control.get(dir);
            int nx = x + next[0];
            int ny = y + next[1];
            if(check(nx, ny)) {
                history.add(String.format("%d%d%d%d",x, y, nx, ny));
                history.add(String.format("%d%d%d%d", nx, ny, x, y));
            }

        }

        return history.size() / 2;

    }
}
