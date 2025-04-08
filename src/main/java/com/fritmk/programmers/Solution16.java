package com.fritmk.programmers;

import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * 기능 개발
 * 문제 유형 : 큐
 * 난이도 : 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586 */
public class Solution16 {

    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> endDay = new ArrayDeque<>();

        for(int i = 0; i< progresses.length; i++) {
            int remain = 100 - progresses[i];
            endDay.add((int) Math.ceil((double)remain / speeds[i]));
        }

        int count;
        while(!endDay.isEmpty()) {
           count = 1;
            int now = endDay.poll();
            while(!endDay.isEmpty() && now >= endDay.peek()) {
                endDay.poll();
                count++;
            }
            list.add(count);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

    }


}
