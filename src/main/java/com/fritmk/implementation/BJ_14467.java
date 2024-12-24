package com.fritmk.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ_14467 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, String> cows = new HashMap<>();

        int result = 0;

        while( n > 0 ) {

            String str = sc.nextLine();
            String[] cow = str.split(" ");

            String number = cow[0];
            String location = cow[1];

            if(cows.get(number) == null) {
                cows.put(number, location);
            } else {
                if(!cows.get(number).equals(location)) {
                    result++;
                    cows.put(number, location);
                }
            }
            n--;
        }

        System.out.println(result);


    }

}
