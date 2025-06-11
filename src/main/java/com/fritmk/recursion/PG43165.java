package com.fritmk.recursion;

public class PG43165 {


    private static int answer = 0;
    private static int targetNumber;
    private static int[] number;

    public int solution(int[] numbers, int target) {

        targetNumber = target;
        number = numbers;

        recursion(0, 0);

        return answer;
    }


    private static void recursion(int n, int sum) { // 다음 순서, 현재까지 계산한 값

        if(n == number.length){
            if (sum == targetNumber) answer++;
            return;
        }

        recursion(n + 1, sum - number[n]);
        recursion(n + 1, sum + number[n]);
    }
}
