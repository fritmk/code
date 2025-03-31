package com.fritmk.bruteForce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/22864
public class BJ_22864 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 피로도
        int b = sc.nextInt(); // 일
        int c = sc.nextInt(); // 피로도 해소
        int m = sc.nextInt(); // 피로도 최대치

        // 최대 얼마나 많은 일을 할 수 있는지 ...
        // 포인트 : 일을 최대한 많이 해야 함. 근데 피로도가 M까지 되면 그 이후에는 무조건 쉬어야 함
        int work = 0;
        int stress = 0;

        for(int i = 0; i < 24; i++) {

            // 일을 해야하는 데 최대 피로도를 넘길 경우엔 쉬어야 함
            if(stress + a > m) {
                stress -= c;
                if(stress < 0) {
                    stress = 0;
                }
                continue;
            }
            work += b;
            stress += a;
        }

        System.out.println(work);


    }

}
