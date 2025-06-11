package com.fritmk.recursion;

public class PG84512 {


    private final String[] alphabet = {"A", "E", "I", "O", "U"};
    private int answer = 0;
    private int result = 0;
    private boolean found = false;

    public int solution(String word) {
        backTracking("", word);
        return result;
    }

    private void backTracking(String current, String target) {
        if (found) return;

        if (current.equals(target)) {
            result = answer;
            found = true;
            return;
        }

        if (current.length() == 5) return;

        for (int i = 0; i < alphabet.length; i++) {
            answer++;
            backTracking(current + alphabet[i], target);
        }
    }
}
