package com.fritmk.simulation;
import java.util.ArrayList;
import java.util.Collections;
/**
 * [3차] n진수 게임
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
public class P17687 {


    class Solution {
        public String solution(int n, int t, int m, int p) {

            ArrayList<Integer> list = new ArrayList<>();

            int max = t * m;
            int N = 0;

            while (list.size() < max) {
                if (N == 0) {
                    list.add(0);
                } else {
                    int number = N;
                    ArrayList<Integer> temp = new ArrayList<>();
                    while (number > 0) {
                        temp.add(number % n);
                        number = number / n;
                    }
                    Collections.reverse(temp);
                    list.addAll(temp);
                }
                N++;
            }

            int index = p - 1;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                if (list.get(index) < 10) {
                    sb.append(list.get(index));
                } else {
                    sb.append((char) ('A' + (list.get(index) - 10)));
                }

                index = index + m;
            }

            return sb.toString();

        }
    }

}
