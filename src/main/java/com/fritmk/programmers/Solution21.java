package com.fritmk.programmers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 오픈 채팅방
 * 문제유형 : 해시
 * 난이도 : 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 * 의견 : 같은 배열에 대한 반복문을 꼭 한번만 돌릴 필요가 없다 ,.
 */
public class Solution21 {

    public String[] solution(String[] record) {

        HashMap<String, String> users = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(String rc : record) {
            String[] r = rc.split(" ");
            String cmd = r[0];
            if(cmd.equals("Enter") || cmd.equals("Change")) {
                users.put(r[1], r[2]);
            }
        }

        for(String rc : record) {
            String[] r = rc.split(" ");
            String cmd = r[0];

            switch(cmd) {
                case "Enter":
                    list.add( users.get(r[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add( users.get(r[1]) + "님이 나갔습니다.");
                    break;
                default:
                    break;
            }

        }

        return list.stream().toArray(String[]::new);
    }
}
