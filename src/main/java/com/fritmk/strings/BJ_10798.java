package com.fritmk.strings;

import java.util.Scanner;

public class BJ_10798 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[5][15];

        for(int i = 0; i < 5; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                String s = arr[j][i];
                if(s != null && !s.equals("")) {
                    result.append(s);
                }
            }
        }
        System.out.println(result);


    }
}