package com.fritmk.programmers;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * 신고 결과 받기
 * 문제 유형 : 해시
 * 난이도 : 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
public class Solution22 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];


        HashMap<String, ArrayList<String>> userReport = new HashMap<>();
        HashMap<String, Integer> block = new HashMap<>();

        HashMap<String, Integer> mail = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            mail.put(id_list[i], 0);
        }

        for(String r : report) {
            String[] rp = r.split(" ");
            ArrayList<String> a= userReport.getOrDefault(rp[0], new ArrayList<>());
            a.add(rp[0]);
            userReport.put(rp[1], a);// 신고 당한자 - 신고자
            block.put(rp[0], block.getOrDefault(rp[0], 0) + 1); // 신고 당한 자 - 횟수
        }

        for(String key : block.keySet()) {
            if(block.get(key) >= k) {
                ArrayList<String> user = userReport.get(key);
                for(int i = 0; i < user.size(); i++) {
                    String usr = user.get(i);
                    mail.put(usr, mail.get(usr) + 1);
                }
            }
        }


        for(int i = 0; i < id_list.length; i++) {
            answer[i] = mail.getOrDefault(id_list[i], 0);
        }

        return answer;
    }

}
