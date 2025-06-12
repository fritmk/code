package com.fritmk.programmers.sorting;
import java.util.ArrayList;
/**
 * 가장 큰 수
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Solution55 {


    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for(int n : numbers) {
            list.add(String.valueOf(n));
        }

        list.sort(
                (o1, o2) -> {
                    int a = Integer.parseInt(o1 + o2);
                    int b = Integer.parseInt(o2 + o1);
                    return Integer.compare(b, a);
                }
        );

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }


}
