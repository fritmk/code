package com.fritmk.programmers.backTracking;

/**
 * N-Queen
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 */
public class Solution46_2 {

    private static int answer = 0;
    private static int[] queen; // queen[row] = col; 각 행(row)에 놓인 퀸의 열(col) 위치

    public int solution(int n) {

        queen = new int[n];
        backTracking(0, n);
        return answer;
    }

    private static void backTracking(int row, int n) {

        if(row == n) { // 모든 행에 성공적으로 배치
            answer++;
            return;
        }

        for(int col = 0 ; col < n; col++) {
            if(isValid(row, col)) {
                queen[row] = col;
                backTracking(row + 1, n);
            }
        }

    }

    private static boolean isValid(int row, int col){
        for(int i = 0; i < row; i++) {
            if(queen[i] == col) return false;
            if(Math.abs(i -row) == Math.abs(queen[i] - col))  return false;
        }
        return true;
    }

}
