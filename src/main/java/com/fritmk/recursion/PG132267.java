package com.fritmk.recursion;

/**
 *  콜라문제
 *  난이도: 1
 *  https://school.programmers.co.kr/learn/courses/30/lessons/132267
 */
public class PG132267 {

    private static int result = 0;
    private static int A, B;// 나머지

    //  빈 병 a개를 가져다주면 콜라 b병을 주는 마트가 있을 때, 빈 병 n개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제
    public int solution(int a, int b, int n) {
        A = a;
        B = b;

        // cal(n);
        while(n < a) {
            result += n / a * b;
            n = (n / a * b) + (n % A);
        }

        return result;
    }

    private static void cal(int n) {

        if(n < A) {
            return;
        }

        int newBottle =  n / A * B;
        int remain = n % A;
        result += newBottle;
        cal(newBottle + remain);

    }

}
