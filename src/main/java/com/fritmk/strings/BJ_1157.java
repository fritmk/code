package com.fritmk.strings;

import java.util.Scanner;

public class BJ_1157 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();

        int[] list = new int[26];

        for(int i = 0; i < str.length(); i++) {
            list[str.charAt(i) - 'a'] ++;
        }

        int max = Integer.MIN_VALUE;
        int preMax = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0;  i < list.length; i++) {
            int a = list[i];
            if(a >= max) {
                preMax = max;
                max = a;
                index = i;
            }
        }

        System.out.println(preMax != max ? (char)(index + 'A') : "?");

    }
}
