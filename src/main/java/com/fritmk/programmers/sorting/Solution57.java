package com.fritmk.programmers.sorting;

import java.util.PriorityQueue;
/**
 * 지형이동
 * 난이도 : 4
 * https://school.programmers.co.kr/learn/courses/30/lessons/62050
 */
public class Solution57 {

    public int solution(int[][] land, int height) {
        int answer = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        int[] nx = {-1, 0, 1, 0};
        int[] ny = {0, -1, 0, 1};

        boolean[][] visited = new boolean[land.length][land[0].length];

        queue.add(new Node(0, 0, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.x][node.y]) continue;
            visited[node.x][node.y] = true;
            answer += node.cost;

            for(int i = 0 ; i < 4; i++ ){
                int nextX = node.x + nx[i];
                int nextY = node.y + ny[i];

                if(nextX < 0 || nextX >= land.length || nextY < 0 || nextY >= land[0].length ) continue;
                if(visited[nextX][nextY]) continue;

                int cost = Math.abs(land[nextX][nextY] - land[node.x][node.y]);
                if(cost <= height) {
                    cost = 0;
                }
                queue.add(new Node(nextX, nextY, cost));
            }
        }

        return answer;

    }

    private static class Node {
        int x, y, cost;
        public Node(int x, int y ,int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
