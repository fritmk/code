package com.fritmk.programmers.backTracking;

/**
 * N-Queen
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 */

// 시간초과 ->  N-Queen은 같은 행에 하나만 놓는 구조
public class Solution46 {

    private static boolean[][] chess;
    private static boolean[][] visited;
    private static int answer = 0;

    public int solution(int n) {
        chess = new boolean[n][n];
        visited = new boolean[n][n];
        backTracking(0);

        return answer;
    }

    private static void backTracking(int count) {

        if(count == chess.length) {
            answer++;
            return;
        }

        for(int i = 0; i < chess.length; i++) {
            for(int j = 0; j < chess[0].length; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    if(check(i, j)) {
                        chess[i][j] = true;
                        backTracking(count+1);
                        chess[i][j] = false;
                    }
                    visited[i][j] = false;
                } else {
                    return;
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        for(int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j]) {
                    // 같은 열 또는 같은 행
                    if (i == x || j == y) return false;

                    // 대각선 체크
                    if (Math.abs(x - i) == Math.abs(y - j)) return false;
                }
            }
        }
        return true;
    }



}
