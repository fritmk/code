package com.fritmk.strings;

import java.util.Scanner;


public class BJ_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String x = sc.nextLine();

        int result = 0;
        for(int i = 0;  i < n; i++){
            result += Integer.parseInt(x.substring(i, i+1));
        }

        System.out.println(result);
    }

}
