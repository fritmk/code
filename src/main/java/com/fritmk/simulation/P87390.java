package com.fritmk.simulation;

/**
 * n^2 배열 자르기
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */
public class P87390 {

    public int[] solution(int n, long left, long right) {

        int size = (int)(right - left + 1);

        int[] answer = new int[size];

        for(int i = 0; i < size; i++) {
            long index = left + i;
            int x = (int)(index / n);
            int y = (int)(index % n);

            answer[i] = Math.max(x, y) + 1;
        }


        return answer;

    }
}
