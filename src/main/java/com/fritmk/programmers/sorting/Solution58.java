package com.fritmk.programmers.sorting;

import java.util.Arrays;
import java.util.HashSet;

public class Solution58 {

    // 시간 초과
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        for(int i = 0; i < phone_book.length; i++){
            int n = i + 1;
            while(n <  phone_book.length) {
                if(phone_book[i].startsWith(phone_book[n++])) return false;
            }

        }

        return answer;
    }


    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));

        for(String s: phone_book) {
            for(int i = 0; i < s.length(); i++) {
                if (set.contains(s.substring(0,i))) return false;
            }
        }
        return answer;
    }
}