package com.fritmk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = {};

            // (1)
            int[][] arr = new int[n][n];

            StringBuilder sb = new StringBuilder();
            // (2)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i <= j) {
                        arr[i][j] = j + 1;
                    } else {
                        arr[i][j] = i + 1;
                    }
                    sb.append(String.valueOf(arr[i][j]));
                }
            }


        }
    }
}