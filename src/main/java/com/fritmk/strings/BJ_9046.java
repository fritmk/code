package com.fritmk.strings;

import java.util.Scanner;

public class BJ_9046 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String a = "abcdefghijklmnopqrstuvwxyz";
        int num = a.split("").length;
        int[] list;

        while(n > 0) {
            n--;
            list = new int[num];

            String str = sc.nextLine().toLowerCase();

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' ') {
                    continue;
                }
                int index = str.charAt(i) - 'a';
//                System.out.println(str.charAt(i));
                list[index] = list[index] + 1;
            }

            int nowMax = Integer.MIN_VALUE;
            int preMax = Integer.MIN_VALUE;
            int resultIndex = -1;

            for(int i = 0; i< list.length; i++) {
                if(list[i] >= nowMax) {
                    preMax = nowMax;
                    nowMax = list[i];
                    resultIndex = i;
                }
            }

            if(nowMax != preMax) {
                System.out.println((char) (resultIndex + 'a'));
            } else {
                System.out.println("?");
            }

        }


    }
}
