package com.fritmk.programmers.dp;

import java.util.Arrays;

/**
 * LIS 길이 계산하기
 * 난이도: 3
 */
public class Solution68 {

    private static int[] dp;

    private static int solution(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();

    }


}
