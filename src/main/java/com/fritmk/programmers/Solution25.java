package com.fritmk.programmers;

/**
 * 트리 순회
 * 문제 유형: 트리
 * 난이도 : 1
 */
public class Solution25 {


    public String[] solution(int[] nodes) {

        String[] result = new String[3];

        result[0] = preOrder(nodes, 0).trim();
        result[1] = inOrder(nodes, 0).trim();
        result[2] = postOrder(nodes, 0).trim();

        return result;

    }


    // 부모노드(자신) - 왼쪽 노드 - 오른쪽 노드
    public static String preOrder(int[]nodes, int idx) {
        if(idx >= nodes.length) {
            return "";
        }
        return nodes[idx] + " " + preOrder(nodes,idx * 2 + 1) +  preOrder(nodes, idx * 2 + 2);
    }

    public static String inOrder(int[] nodes, int idx) {
        if(idx >= nodes.length) {
            return "";
        }

        return inOrder(nodes, idx * 2 + 1) + nodes[idx] + " " + inOrder(nodes, idx * 2 + 2);
    }

    public static String postOrder(int[] nodes, int idx) {
        if(idx >= nodes.length) return "";

        return postOrder(nodes, idx * 2 +  1) + postOrder(nodes, idx * 2 + 2) + nodes[idx] + " ";
    }



}
