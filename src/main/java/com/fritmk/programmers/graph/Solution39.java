package com.fritmk.programmers.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 미로 탈출
 * 문제 유형: 그래프 (bfs)
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */
public class Solution39 {

    private static int[] nx = {0, -1, 0, 1};
    private static int[] ny = {-1, 0 ,1, 0};

    private static char[][] map;
    private static int n, m;


    public int solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();

        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        Node start = null;
        Node end = null;
        Node lever = null;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char c = map[i][j];
                if(c == 'S') {
                    start = new Node(i, j);
                } else if(c == 'E') {
                    end = new Node(i, j);
                } else if(c == 'L') {
                    lever = new Node(i, j);
                }
            }
        }

        int result1 = bfs(start, lever);
        int result2 = bfs(lever, end);

        if(result1 == -1 || result2 == -1) {
            return -1;
        }


        return result1 + result2;
    }

    public static int bfs(Node start, Node end) {

        int[][] dist = new int[n][m];

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(start);
        dist[start.x][start.y] = 0;

        while(!queue.isEmpty()) {

            Node now = queue.poll();

            // 이미 end 노드까지 갔을 때
            if(now.x == end.x && now.y == end.y){
                return dist[now.x][now.y];
            }

            for(int i = 0;  i < 4; i++) {

                int nextX = now.x + nx[i];
                int nextY = now.y + ny[i];

                // 제한 구역을 넘어설 때
                if(nextX < 0 || nextY < 0 || nextX >=n || nextY >= m) continue;
                // 벽일 때
                if(map[nextX][nextY] == 'X') continue;
                // 이미 지났을 때
                if(dist[nextX][nextY] > 0)  continue;

                queue.add(new Node(nextX, nextY));
                dist[nextX][nextY] = dist[now.x][now.y] + 1;
            }
        }

        return dist[end.x][end.y] == 0 ? -1 : dist[end.x][end.y];

    }


    private static class Node {
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

