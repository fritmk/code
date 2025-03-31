package com.fritmk.bruteForce;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class BJ_2309 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sc.close();

        Arrays.sort(arr);
        boolean find = false;

        for(int i = 0; i < 8; i ++) {
            for(int j = i + 1; j  < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    for(int a = 0; a < 9; a++) {
                        if(a != i && a != j) {
                            sb.append(arr[a]).append("\n");
                        }
                    }
                    find = true;
                    break;
                }
            }
            if(find) break;
        }
        System.out.println(sb);

    }
}