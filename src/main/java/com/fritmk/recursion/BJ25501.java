package com.fritmk.recursion;

import java.util.Scanner;

/**
 * 재귀의 귀재
 * 난이도: 브론즈2
 * https://www.acmicpc.net/problem/25501
 */
public class BJ25501 {

    private static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n > 0) {

            String str = sc.nextLine();
            count = 0;
            System.out.println(isPalindrome(str) + " " + count);
            n--;
        }
        sc.close();
    }

    private static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    private static int recursion(String str, int start, int end) {
        count++;
        if(start >= end) return 1;
        if(str.charAt(start) == str.charAt(end)) {
            return recursion(str, start + 1, end -1);
        } else {
            return 0;
        }
    }


}
