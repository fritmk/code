package com.fritmk.programmers;

import java.util.HashSet;

/**
 * 영어 끝말잇기
 * 문제 유형: 집합
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class Solution32 {

    public int[] solution(int n, String[] words) {
        int[] answer = {};

        HashSet<String> set = new HashSet<>();
        String beforeWord = words[0];
        set.add(words[0]);

//        int turn, number;
        for(int i = 1; i < words.length; i++) {

//            number = i / n + 1;
//            turn =  i / n + 1;

            String end = beforeWord.substring(beforeWord.length() -1);
            //!beforeWord.substring(beforeWord.length() -1).equals(words[i].substring(0,1))
            if(!words[i].startsWith(end) || set.contains(words[i])) {
                return new int[]{ (i%n+1), (i/n+1)};
            }
            set.add(words[i]);
            beforeWord = words[i];
        }

        return new int[]{0, 0};
    }


}
