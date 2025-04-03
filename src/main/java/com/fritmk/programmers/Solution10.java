package com.fritmk.programmers;


import java.util.Calendar;
import java.util.Stack;

/**
 * 괄호 회전하기
 * 문제 유형 : 스택
 * 난이도 : 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
public class Solution10 {

    public int solution(String s) {

        int count = 0;
        int total = s.length();

        for(int start = 0; start < total; start++) { // 칸 옮기기 용

            Stack<Character> stack = new Stack<>();

            boolean result = true;

             for(int i = 0; i < total; i++) {
                 int index = (start + i) % total;
                 char c = s.charAt(index);
                 if(c == '(' || c =='[' || c == '{') {
                     stack.push(c);
                 } else {
                     if(stack.isEmpty()) {
                         result = false;
                         break;
                     }
                     switch(c) {
                         case ')':
                             if(stack.peek() != '(') {
                                 result = false;
                             } else {
                                 stack.pop();
                             }
                             break;
                         case ']':
                             if(stack.peek() != '[') {
                                 result = false;
                             } else {
                                 stack.pop();
                             }
                             break;
                         case '}':
                             if(stack.peek() != '{') {
                                 result = false;
                             } else {
                                 stack.pop();
                             }
                             break;
                     }
                 }
             }

             if(stack.isEmpty() && result) count++;
        }
        return count;
    }

}
