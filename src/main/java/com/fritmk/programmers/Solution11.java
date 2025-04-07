package com.fritmk.programmers;

import java.util.Stack;

/**
 * 짝지어 제거하기
 * 문제 유형 :
 * 난이도 : 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class Solution11 {

    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0;  i < s.length(); i++) {
            char c = s.charAt(i);

            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;

    }

}
