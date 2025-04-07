package com.fritmk.programmers;

import java.util.HashMap;
import java.util.Stack;

/**
 * 크레인 인형뽑기 게임
 * 문제 유형 :
 * 난이도 : 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
public class Solution13 {

    public int solution(int[][] board, int[] moves) {

        HashMap<Integer, Stack<Integer>> boardMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>(); // 바구니


        for(int i = 0; i < board.length; i++) {
            Stack<Integer> b = new Stack<>();
            for(int j = board.length-1; j >= 0; j--) {
                if(board[j][i] != 0) {
                    b.push(board[j][i]);
                }
            }
            boardMap.put(i+1, b);
        }

        int answer = 0;
        for(int move : moves) { // 꺼내는 곳 선택
            Stack<Integer> b = boardMap.get(move);
            if(!b.isEmpty()) {
                int doll = b.pop();
                if(! stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer+=2;
                } else {
                    stack.push(doll);
                }
            }
        }

        return answer;


    }


}
