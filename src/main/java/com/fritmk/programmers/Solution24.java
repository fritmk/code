package com.fritmk.programmers;

import java.util.*;

/**
 * 메뉴 리뉴얼
 * 문제 유형 : 해시
 * 난이도 : 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
public class Solution24 {

    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    private static HashMap<Integer, Integer> max;

    public String[] solution(String[] orders, int[] course) {

        courseMap = new HashMap<>();
        max = new HashMap<>();

        for(int i : course) {
            courseMap.put(i, new HashMap<>());
            max.put(i, 0);
        }

        for(String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> result = new ArrayList<>();

        for(Integer key : courseMap.keySet()) {
            int maxCount = max.get(key);
            HashMap<String, Integer> map = courseMap.get(key);
            for(String menu : map.keySet()) {
                if(map.get(menu) == maxCount && maxCount >= 2) {
                    result.add(menu);
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);

    }

    public static void combinations(int idx, char[] order, String result) {
        System.out.println(result);

        if(courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0 ) + 1);
            if(max.get(result.length()) < map.get(result)) {
                max.put(result.length(), map.get(result));
            }
        }

        for(int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }

    }

}
