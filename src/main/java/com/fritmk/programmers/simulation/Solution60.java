package com.fritmk.programmers.simulation;

import java.util.Arrays;

/**
 * 두 행렬을 곱한 후 전치 행렬 만들기
 */
public class Solution60 {


    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int[][] result = Solution60.solution(matrix1, matrix2);

        System.out.println("행렬 곱셈 후 전치 행렬:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] solution(int[][] matrix1, int[][] matrix2) {

        int[][] result = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        // 전치행렬 방법 (1)
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < i; j++) {
//                int temp = result[i][j];
//                result[i][j] = result[j][i];
//                result[j][i] = temp;
//            }
//        }

        // 전치행렬 방법(2)
        int[][] result2 = new int[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                result2[j][i] = result[i][j];
            }
        }

        return result2;

    }
}
