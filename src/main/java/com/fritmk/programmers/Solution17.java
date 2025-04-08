package com.fritmk.programmers;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
/**
 * 카드 뭉치
 * 문제 유형 : 큐
 * 난이도 : 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 */
public class Solution17 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> c1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> c2 = new LinkedList<>(Arrays.asList(cards2));


        for(String g : goal) {
            if(!c1.isEmpty() && c1.peek().equals(g)) {
                c1.poll();
            } else if(!c2.isEmpty() && c2.peek().equals(g)) {
                c2.poll();
            } else {
                return "No";
            }
        }


        return "Yes";
    }

    public String solutionWithoutQueue(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int card1Index = 0;
        int card2Index = 0;

        for(int i = 0; i < goal.length; i++) {
            String g = goal[i];
            if(card1Index < cards1.length && cards1[card1Index].equals(g)) {
                card1Index++;
            } else if(card2Index < cards2.length && cards2[card2Index].equals(g)) {
                card2Index++;
            } else {
                return "No";
            }
        }

        return answer;
    }
}
