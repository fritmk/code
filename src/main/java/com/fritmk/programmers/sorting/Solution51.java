package com.fritmk.programmers.sorting;

/**
 * 정렬이 완료된 두 배열 합치기
 */
public class Solution51 {

    private static int[] solution(int[] arg1, int[] arg2) {
        int[] list = new int[arg1.length + arg2.length]; // 0,1,2,3, 4,5,6,7
        int p1 = 0, p2 = 0, idx = 0;

        while(p1 < arg1.length && p2 < arg2.length) {
            if(arg1[p1] <= arg2[p2]) {
                list[idx++] = arg1[p1++];
            } else {
                list[idx++] = arg2[p2++];
            }
            idx++;
        }

        while(p1 < arg1.length) {
            list[idx++] = arg1[p1++];
        }
        while(p2 < arg2.length) {
            list[idx++] = arg2[p2++];
        }
        return list;

    }

}
