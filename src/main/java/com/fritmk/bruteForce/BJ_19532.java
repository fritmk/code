package com.fritmk.bruteForce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/19532
public class BJ_19532 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        sc.close();

        for(int x = -999; x < 1000; x++) {
            for(int y = -999; y < 1000; y++) {
                if((a * x) + (b * y) == c && (d * x) + (e * y) == f) {
                    System.out.println(x + " " + y);
                    break;
                }
            }
        }

    }

}
