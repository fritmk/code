package com.fritmk.strings;

import java.util.Scanner;


public class BJ_11720 {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        String n = sc.nextLine();
        String str = sc.nextLine();

        int result = 0;
        for(int i = 0; i < Integer.parseInt(n); i++) {
//            result += str.charAt(i) - '0';
            result += Integer.parseInt(str.substring(i,i+1));
        }
        System.out.println(result);
    }

}
