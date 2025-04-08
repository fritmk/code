package com.fritmk.programmers;

import java.util.HashSet;

/**
 * 두 개의 수로 특정값 만들기
 * 문제유형 : 해시
 * 난이도 : 1
 */
public class Solution18 {

    public boolean solution(int[] arr, int target) {

        HashSet<Integer> hashSet = new HashSet<>();
        for(int a: arr) {
            hashSet.add(a);
        }

        for(int a : arr) {
            if(hashSet.contains(target - a)) {
                return true;
            }
        }

        return false;

    }
}
