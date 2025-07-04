package com.fritmk.dataStructures;
import java.util.ArrayList;
/**
 * [1차] 캐시
 * 난이도: 2
 * 문제유형: 자료구조 (ArrayList)
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
public class P17680 {

    public int solution(int cacheSize, String[] cities) {

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        ArrayList<String> cache = new ArrayList<>();
        int answer = 0;

        for(int i = 0; i < cities.length; i++) {

            String city = cities[i].toLowerCase();

            if(cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                if(cache.size() == cacheSize && cache.size() > 0) {
                    cache.remove(cache.get(0));
                }
                cache.add(city);
            }
        }
        return answer;
    }

}
