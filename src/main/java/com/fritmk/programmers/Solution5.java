package com.fritmk.programmers;

import java.util.ArrayList;

/**
 * Array
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * */
public class Solution5 {

    public static int[] solution(int[] answers) {
        int[] scope = new int[3];

        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
        };

        int maxScope = 0;
        for(int i = 0; i < 3; i++) {
            int[] answer = pattern[i];
            for(int a = 0; a < answers.length; a++) {
                if(answer[a % answer.length] == answers[a]) {
                    scope[i]++;
                    if(maxScope < scope[i]) {
                        maxScope = scope[i];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(maxScope == scope[i]) {
                result.add(i+1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
