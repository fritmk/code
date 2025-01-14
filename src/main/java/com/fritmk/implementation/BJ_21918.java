package com.fritmk.implementation;

import java.io.PrintStream;
import java.util.Scanner;

public class BJ_21918 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();
//        System.out.println(temp);

        int n = Integer.parseInt(temp.split(" ")[0]);
        int m = Integer.parseInt(temp.split(" ")[1]);


        temp = sc.nextLine();

        String[] list = temp.split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(list[i]);
        }


        String commend;

        while(m > 0) {
            m--;

            commend = sc.nextLine();
            String[] cmd = commend.split(" ");
            String a = cmd[0];
            int l = Integer.parseInt(cmd[1]) - 1;
            int x = Integer.parseInt(cmd[2]) - 1;

            if(a.equals("1")) {
                x += 1;
                arr[l] = x;
            } else if(a.equals("2")) {
                for(int i = l; i <= x; i++) {
                    if (arr[i] == 0) {
                        arr[i] = 1;
                    } else {
                        arr[i] = 0;
                    }
                }
            } else if(a.equals("3")) {
                for(int i = l; i<=x; i++) {
                    arr[i] = 0;
                }
            } else {
                for(int i = l; i<=x; i++) {
                    arr[i] = 1;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
            if(i != arr.length - 1) result.append(" ");
        }

        System.out.println(result);

        sc.close();

    }
}
