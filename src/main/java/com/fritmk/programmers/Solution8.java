package com.fritmk.programmers;

import java.util.Stack;

/**
 * 스택
 * 올바른 괄호
 * 난이도 : 2
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12909">...</a>
 */
public class Solution8 {

    public boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.add('(');
            } else {
                if(stack.isEmpty()) {
                    result = false;
                    break;
                }
            }
        }

        return stack.isEmpty() && result;
    }


}
