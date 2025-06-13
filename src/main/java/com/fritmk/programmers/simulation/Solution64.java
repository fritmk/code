package com.fritmk.programmers.simulation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 카펫
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Solution64 {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        ArrayList<Position> list = new ArrayList<>();
        int n = brown + yellow;

        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                if((n / i) < i) break;
                list.add(new Position(n / i, i));
            }
        }

        for(Position p : list) {
            int b = (p.x * 2 + (p.y - 2) * 2);
            if( b == brown && n - b == yellow ) {
                return new int[]{p.x, p.y};
            }
        }

        return answer;
    }

    private static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
