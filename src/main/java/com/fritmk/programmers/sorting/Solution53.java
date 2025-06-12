package com.fritmk.programmers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 정수 내림차순으로 배치하기
 * 난이도: 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/12933
 */
public class Solution53 {
    public long solution(long n) {

        String str = String.valueOf(n);
        String[] list = str.split("");

        Arrays.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }

        return Long.parseLong(sb.toString());

    }

}
