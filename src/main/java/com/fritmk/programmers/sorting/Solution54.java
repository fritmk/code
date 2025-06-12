package com.fritmk.programmers.sorting;

import java.util.Arrays;

/**
 * K번째 수
 * 난이도: 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Solution54 {

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = {};
        answer = new int[commands.length];

        int count = 0;
        for(int[] command : commands) {
            int i = command[0]- 1;
            int j = command[1] -1;
            int n = command[2] -1;

//            int[] list = new int[j - i + 1];
//            for(int idx = 0; idx < list.length; idx++) {
//                list[idx] = array[i++];
//            }
            int[] list = Arrays.copyOfRange(array, i, j+1);

            Arrays.sort(list);
            answer[count] = list[n];
            count++;
        }

        return answer;
    }

}
