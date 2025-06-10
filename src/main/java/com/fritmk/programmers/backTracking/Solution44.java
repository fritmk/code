package com.fritmk.programmers.backTracking;

/** 스도쿠 퍼즐
 * 난이도 : 3
 */
public class Solution44 {

    private static int[][] board;
    private static int[][] result;

    public static void main(String[] args) {
        int[][] puzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        solution(puzzle);
        printBoard(result);
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int[][] boards) {
        board = boards;

        int[][] newBoard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            newBoard[i] = boards[i].clone();
        }

        backTracking(newBoard);
        return result;
    }

    private static boolean backTracking(int[][] nowBoard) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (nowBoard[i][j] == 0) {
                    for (int n = 1; n <= 9; n++) {
                        if (!(checkRows(nowBoard, i, n) || checkColumn(nowBoard, j, n) || checkBox(nowBoard, i, j, n))) {
                            nowBoard[i][j] = n;
                            if (backTracking(nowBoard)) return true;
                            nowBoard[i][j] = 0; // 되돌리기
                        }
                    }
                    return false; // 가능한 숫자가 없음
                }
            }
        }


        result = new int[9][];
        for (int i = 0; i < 9; i++) {
            result[i] = nowBoard[i].clone();
        }
        return true;
    }

    // 행에 같은 숫자가 있는지 확인
    private static boolean checkRows(int[][] b, int r, int n) {
        for (int i = 0; i < 9; i++) {
            if (b[r][i] == n) return true;
        }
        return false;
    }

    // 열에 같은 숫자가 있는지 확인
    private static boolean checkColumn(int[][] b, int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (b[i][c] == n) return true;
        }
        return false;
    }

    // 3x3 박스에 같은 숫자가 있는지 확인
    private static boolean checkBox(int[][] b, int r, int c, int n) {
        int rowStart = (r / 3) * 3;
        int colStart = (c / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (b[i][j] == n) return true;
            }
        }
        return false;
    }
}
