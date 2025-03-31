package com.fritmk.dataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;
/*
* 큐
* 실버 5
* https://www.acmicpc.net/problem/10845
* */

public class BJ_10845 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int lastNum = 0;

        while(n > 0) {
            String input = br.readLine();
            String cmd = input.split(" ")[0];


            switch(cmd) {
                case "push" :
                    lastNum = Integer.parseInt(input.split(" ")[1]);
                    queue.offer(lastNum);
                    break;
                case "pop"  :
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;
                case "size"  :
                    System.out.println(queue.size());
                    break;
                case "empty" :
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back"  :
                    System.out.println(queue.isEmpty() ? -1 : lastNum);
                    break;
            }
            n--;

        }


    }


}

