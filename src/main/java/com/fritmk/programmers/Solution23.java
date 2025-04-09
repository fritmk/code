package com.fritmk.programmers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 신고 결과 받기
 * 문제 유형 : 해시
 * 난이도 : 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 * 의견 : 중복 신고는 안되기 떄문에 set으로 신고한 사람의 이름을 추가하고, 그 set size로 신고된 횟수를 확인하면 된다. 굳이 count 하는 hashmap을 만들 필요가 없음.
 */
public class Solution23 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution23().solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];


        HashMap<String, HashSet<String>> blockedUser = new HashMap<>();

        for(int i = 0; i < report.length; i++) {
            String[] rp =  report[i].split(" ");
            // 신고당한 사람 - 신고한 사람
            HashSet<String> users = blockedUser.getOrDefault(rp[1], new HashSet<>());
            users.add(rp[0]);
            blockedUser.put(rp[1], users);
        }

        for(String key : blockedUser.keySet()) {
            if(blockedUser.get(key).size() >= k) {
               HashSet<String> users = blockedUser.get(key);
               for(String user : users) {
                   int index = Arrays.asList(id_list).indexOf(user);
                   answer[index]++;
               }
            }
        }

        return answer;
    }

}
