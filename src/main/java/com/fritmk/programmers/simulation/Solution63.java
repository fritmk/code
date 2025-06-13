package com.fritmk.programmers.simulation;

import java.util.HashSet;
import java.util.HashMap;

/**
 * 롤케이크 자르기
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class Solution63 {


    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int n : topping) {
            set.add(n);
            map.put(n, map.get(n) - 1); // 뺴기
            if(map.get(n) == 0) {
                map.remove(n);
            }
            if(map.size() == set.size()) {
                answer++;
            }
        }
        return answer;
    }


}
