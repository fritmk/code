package com.fritmk.programmers.backTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 1부터 N까지 숫자 중 합이 10이 되는 조합 구하기
 * 난이도 : 1
 * 재귀 어렵다.. 하.. ㅠㅠ
 */
public class Solution43 {

    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private static int N;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = solution(5);

        ArrayList<Integer> elem = result.get(2);
        for (int i = 0; i < elem.size(); i++) {
            System.out.print(elem.get(i) + "  ");
        }

    }

    private static ArrayList<ArrayList<Integer>> solution(int n) {

        N = n;
        backtracking(1, 0, new ArrayList<>());

        return result;
    }

    private static void backtracking(int start, int sum, ArrayList<Integer> list){

        if(sum == 10) {
            result.add(list);
            return;
        }

        for(int i = start; i < N+1; i++) {
            if(sum + i <= 10) {
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(i);
                backtracking(i + 1, sum + i, newList);
            }
        }
    }


}
