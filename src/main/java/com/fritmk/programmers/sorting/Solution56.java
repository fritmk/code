package com.fritmk.programmers.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * 튜플
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
public class Solution56 {
    public int[] solution(String s) {
        int[] answer = {};

        s = s.replace("{", "");
        String[] list = s.split("},");
        for(int i = 0; i < list.length; i++) {
            list[i] = list[i].replace("}","");
        }

        Arrays.sort(list, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        int index = 0;
        answer = new int[list.length];

        for(int i = 0; i < list.length; i++) {
            String[] numberList = list[i].split(",");
            for(String n : numberList) {
                if(!numbers.contains(n)) {
                    numbers.add(n);
                    answer[index++] = Integer.parseInt(n);
                }
            }
        }

        return answer;
    }
}
