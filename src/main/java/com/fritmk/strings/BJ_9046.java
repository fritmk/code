package com.fritmk.strings;

import java.util.Scanner;

public class BJ_9046 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] list;

        for(int i = 0; i < n; i++) {

            list = new int[26];
            String str = sc.nextLine();
            str = str.replaceAll(" ", "");

            for(int j = 0; j < str.length(); j++) {
                list[str.charAt(j) - 'a']++;
            }

            int beforeMax = list[0];
            int max = list[0];
            int idx = 0;

            for(int j = 1; j < list.length; j++) {
                if(list[j] >= max) {
                    beforeMax = max;
                    max = list[j];
                    idx = j;
                }
            }

            if(max == beforeMax) {
                System.out.println("?");
            } else {
                System.out.println((char)(idx + 'a'));
            }
        }

    }
}
