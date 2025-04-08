package com.fritmk.programmers;


import java.util.Queue;
import java.util.ArrayDeque;

public class Solution15 {

    public static void main(String[] args) {
        System.out.println(new Solution15().solution(5,2));
    }

    public int solution (int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            for(int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

//        for(int i = 1; i <= k; i++) {
//            if(queue.size() == 1) {
//                break;
//            }
//            if(i != n) {
//                queue.add(queue.poll());
//            } else {
//                queue.poll();
//            }
//        }
        return queue.poll();
    }

}
