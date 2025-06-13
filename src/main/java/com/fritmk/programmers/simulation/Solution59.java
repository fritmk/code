package com.fritmk.programmers.simulation;

import java.util.Arrays;

/**
 * 배열 회전하기
 */
public class Solution59 {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int n = 1; // 90도 회전 횟수

        int[][] result = solution(arr, n);

        System.out.println("회전 결과:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static int[][] solution(int[][] arr, int n){

        while(n > 0) {
            int size = arr.length;
            int[][] newArray = new int[size][size];
            for(int i =0 ; i< size; i++) {
                for(int j = 0 ; j < size; j++) {
                    newArray[j][(size-1) - i] = arr[i][j];
                }
            }
            arr = newArray;
            n--;
        }

        return arr;

    }
}
