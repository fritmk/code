package com.fritmk.programmers;

import java.util.Arrays;
import java.util.Collections;

public class Solution2 {

    private static int[] Solution(int[] arr) {

        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();

    }

}
