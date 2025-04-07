package com.fritmk.programmers;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ArrayList;

/**
 * 주식가격
 * 문제유형 : 스택/큐
 * 난이도 : 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
public class Solution12 {

    public int[] solution(int[] prices) {
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int p : prices) {
            q.add(p);
        }

        while(!q.isEmpty()) {

            int price = q.poll();
            int time = 0;

            for(int i = prices.length - q.size(); i < prices.length; i++) {
                time++;
                if(price <= prices[i]) {
                    break;
                }
            }

            result.add(time);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }

}
