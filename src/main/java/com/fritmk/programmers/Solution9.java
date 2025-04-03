package com.fritmk.programmers;

import java.util.Stack;

/**
 * 10진수를 2진수로 변환하기
 */
public class Solution9 {

    public static void main(String[] args) {
        System.out.println(solution(12345));
    }

    public static String solution(int decimal) {

        Stack<Integer> stack = new Stack<>();

        while(decimal > 0 ){
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();

    }

}
