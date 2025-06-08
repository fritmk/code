package com.fritmk.programmers;

import java.util.Arrays;
import java.util.HashSet;
/**
 * 폰켓몬
 * 문제 유형: 집합
 * 난이도: 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Solution31 {

    public int solution(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        return Math.min(set.size(), nums.length / 2);

//        return Math.min((int)Arrays.stream(nums).distinct().count(), nums.length / 2);
    }

}
