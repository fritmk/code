package com.fritmk.programmers.simulation;

import java.util.Arrays;

public class Solution61 {

    public static void main(String[] args) {

        int[][] result = solution(4);

        System.out.println("행렬 곱셈 후 전치 행렬:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }


    private static int[][] solution(int n) {

        int[][] arr = new int[n][n];
        int num = 1;

        int startRow = 0, endRow = n-1;
        int startCol = 0, endCol = n-1;


        while(startRow <= endRow && startCol <= endCol) {

            for(int i = startCol; i <= endCol; i++) {
                arr[startRow][i] = num++;
            }
            startRow++;

            for(int i = startRow; i <= endRow; i++) {
                arr[i][endCol] = num++;
            }
            endCol--;

            if(startRow <= endRow) {
                for(int i = endCol; i >= startCol; i--) {
                    arr[endRow][i] = num++;
                }
                endRow--;
            }

            if(startCol <= endCol) {
                for(int i = endRow; i >= startRow; i--) {
                    arr[i][startCol] = num++;
                }
                startCol++;
            }

        }
        return arr;
    }

}
