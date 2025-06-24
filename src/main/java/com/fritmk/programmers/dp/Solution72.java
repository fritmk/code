package com.fritmk.programmers.dp;

/**
 * 정수 삼각형
 * 난이도: 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Solution72 {

    public int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;
        int[][] result = new int[n][n];

        result[0][0] = triangle[0][0];

        for(int x = 1; x < n; x++) {
            for(int y = 0; y < triangle[x].length; y++) {
                int left = 0; // 이전 노드의 왼쪽
                int right = 0; // 이전 노드의 오른쪽
                int now = triangle[x][y];

                if(y-1 >= 0) left = result[x-1][y-1];
                if(y <= x-1) right = result[x-1][y];

                result[x][y] = Math.max(now + left, now + right);
            }
        }


        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, result[n-1][i]);
        }

        return answer;
    }
}
