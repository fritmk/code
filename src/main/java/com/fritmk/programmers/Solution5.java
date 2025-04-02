package com.fritmk.programmers;

/**
 * 행렬의 곱셈
 * */
public class Solution5 {


    public int[][] solution (int[][] a, int[][] b) {

        int[][] result = new int[a.length][b[0].length];

        for(int i = 0;  i < a.length; i++) {
            for(int j = 0; j < b[0].length; j++){

                for(int z = 0; z < b.length; z++) {
                    result[i][j] += a[i][z] * b[z][j];
                }

            }
        }

        return result;
    }



}
