package com.fritmk.recursion;

import java.util.Scanner;

/**
 * 팩토리얼 2
 * 난이도: 브론즈5
 * https://www.acmicpc.net/problem/27433
 */
public class BJ27433 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(recursion(n, 1L));
    }

    private static long recursion(int n, long result) {
        if(n < 1) {
            return result;
        }
        result *= n;
        return recursion( n- 1, result);
    }

}
