package com.fritmk.programmers;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 표 편집
 * 난이도 : 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 * (인덱스만을 사용해서 풀이가 가능하다.)
 */
public class Solution14 {

    public static String solution(int n, int k, String[] cmds) {

        Stack<Integer> remove = new Stack<>();
        int size = n;

        for(String cmd : cmds) {
            if(cmd.startsWith("U")) { // 위로
                k -= Integer.parseInt(cmd.split(" ")[1]);
            } else if(cmd.startsWith("D")) { // 아래로
                k += Integer.parseInt(cmd.split(" ")[1]);;
            } else if(cmd.startsWith("C")) { // 삭제
                remove.add(k);
                size--;
                if(k == size) {
                    k--;
                }
            } else if(cmd.startsWith("Z")) { // 복구
                int rm = remove.pop();
                if(rm < k) {
                    k++;
                }
                size++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append("O");
        }
        while(!remove.isEmpty()) {
            sb.insert(remove.pop(), "X");
        }

        return sb.toString();

    }


    public static String solutionTimeout(int n, int k, String[] cmds) {
        StringBuilder answer = new StringBuilder();

        LinkedList<Integer> list = new LinkedList<>();
        Stack<int[]> delete = new Stack<>();

        // 표 작성
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        // 명령어
        for(String cmd : cmds) {

            if(cmd.startsWith("U")) { // 위로
                int up = Integer.parseInt(cmd.split(" ")[1]);
                k -= up;
            } else if(cmd.startsWith("D")) { // 아래로
                int down = Integer.parseInt(cmd.split(" ")[1]);
                k += down;
            } else if(cmd.startsWith("C")) { //
                int[] del = {k, list.get(k)};
                delete.add(del);
                list.remove(k);
                if(list.size() <= k) {
                    k = list.size()-1;
                }
            } else if(cmd.startsWith("Z")) { // 복
                //원래대로 복구할 행이 없을 때(즉, 삭제된 행이 없을 때) "Z"가 명령어로 주어지는 경우는 없습니다.
                int[] del = delete.pop();
                list.add(del[0], del[1]);
                if(k >= del[0]) {
                    k += 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(list.contains(i)) {
                answer.append("O");
            } else {
                answer.append("X");
            }
        }


        return answer.toString();
    }

}
