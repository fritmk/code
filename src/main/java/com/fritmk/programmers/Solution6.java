package com.fritmk.programmers;

import java.util.HashMap;

/**
 * 실패율
 * */
public class Solution6 {

    public int[] solution(int N, int[] stages) {

        int[] challenge = new int[N + 2];
        double[] stage = new double [N + 2];

        for (int k : stages) {
            challenge[k] += 1;
        }

        for (int s : stages) {
            for (int j = 1; j <= s; j++) {
                stage[j] += 1;
            }
        }

        HashMap<Integer, Double> result = new HashMap<>();

        for(int i = 1; i < N+1; i++) {
            result.put(i, challenge[i] / stage[i]);
        }

        return result.entrySet().stream().sorted(
                (o1, o2) -> Double.compare(o2.getValue(), o1.getValue())
        ).mapToInt(HashMap.Entry::getKey).toArray();


    }


}
