package com.fritmk.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
* 스택
* 실버 5
* https://www.acmicpc.net/problem/10828
* */
public class BJ_10828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        CustomStack<String> stack = new CustomStack<>();

        while(n > 0) {

            String in = br.readLine();
            String cmd = in.split(" ")[0];

            switch (cmd) {
                case "push" -> {
                    String num = in.split(" ")[1];
                    stack.push(num);
                }
                case "pop" -> {
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                }
                case "size" -> System.out.println(stack.size());
                case "empty" -> System.out.println(stack.isEmpty() ? 1 : 0);
                case "top" -> System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
            n--;
        }

    }

    static class CustomStack<T> {
        ArrayList<T> list = new ArrayList<>();

        public void push(T num) {
            list.add(num);
        }

        public T pop() {
            T num = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return num;
        }

        public int size() {
            return list.size();
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public T peek() {
            return list.get(list.size() - 1);
        }

    }
}
