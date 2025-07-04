package com.fritmk.dataStructures;

import java.util.HashMap;

/**
 * [1차] 뉴스 클러스터링
 * 난이도: 2
 * 문제유형: 문자열, 해시
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */
public class P17677 {
    public int solution(String str1, String str2) {

        HashMap<String, Integer> A = new HashMap<>();
        HashMap<String, Integer> B = new HashMap<>();

        for(int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);
            s = s.toLowerCase();
            if(s.charAt(0) < 'a' || s.charAt(0) > 'z'
                    || s.charAt(1) < 'a' || s.charAt(1) > 'z') {
                continue;
            }
            A.put(s, A.getOrDefault(s, 0) + 1);
        }

        for(int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);
            s = s.toLowerCase();
            if(s.charAt(0) < 'a' || s.charAt(0) > 'z'
                    || s.charAt(1) < 'a' || s.charAt(1) > 'z') {
                continue;
            }
            B.put(s, B.getOrDefault(s, 0) + 1);
        }

        int union = 0;
        int intersection = 0;

        for(String key : A.keySet()) {
            if(B.containsKey(key)){
                union +=  Math.max(A.get(key), B.get(key));
                intersection += Math.min(A.get(key), B.get(key));
            } else {
                union += A.get(key);
            }
        }

        for (String key : B.keySet()) {
            if (!A.containsKey(key)) {
                union += B.get(key);
            }
        }

        if(union == 0.0) {
            return 65536;
        } else {
            return (int)Math.floor(( (double) intersection / union) * 65536);
        }

    }
}
