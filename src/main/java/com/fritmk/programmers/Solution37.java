package com.fritmk.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 게임 맵 최단 거리
 * 문제 유형: 그래프(BFS)
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class Solution37 {

    private static int[] nx = {0, -1, 0, 1};
    private static int[] ny = {-1, 0, 1, 0};
    public int solution(int[][] maps) {
        int answer = 0;

        Queue<Node> queue = new ArrayDeque<>();

        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];

        dist[0][0] = 1;
        queue.add(new Node(0,0));

        while(!queue.isEmpty()) {

            Node nowNode = queue.poll();
            int x = nowNode.x;
            int y = nowNode.y;

            for(int i = 0; i < 4; i++) {
                int nextX = x + nx[i];
                int nextY =y + ny[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }

                if(maps[nextX][nextY] == 0) {
                    continue;
                }

                if(dist[nextX][nextY] == 0) {
                    queue.add(new Node(nextX, nextY));
                    dist[nextX][nextY] = dist[x][y]+ 1;
                }
            }

        }


        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }

    private static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
