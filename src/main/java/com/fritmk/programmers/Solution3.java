package com.fritmk.programmers;

import java.util.HashSet;

/**
 * 두 개 뽑아서 더하기
 * */
public class Solution3 {


    public static int[] solution(int[] numbers) {
        HashSet<Integer> result = new HashSet<>();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }

        return result.stream().sorted().mapToInt(Integer::intValue).toArray();

    }

}
