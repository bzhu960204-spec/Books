package LeetCode.TopInterviewQuestions;

import java.util.Arrays;
import java.util.List;

/**
 * Not the best solution
 */
public class Q130 {
    /*
    Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region.
    */
    boolean[][] booleanArray;

    public void solve(char[][] board) {
        booleanArray = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            searchAndMark(new Point(i, 0), board);
            searchAndMark(new Point(i, board[0].length - 1), board);
        }
        for (int i = 1; i < board[0].length - 1; i++) {
            searchAndMark(new Point(0, i), board);
            searchAndMark(new Point(board.length - 1, i), board);
        }
        for (int i = 0; i < booleanArray.length; i++) {
            for (int j = 0; j < booleanArray[0].length; j++) {
                if (!booleanArray[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void searchAndMark(Point point, char[][] board) {
        if (board[point.getX()][point.getY()] == 'O') {
            if (!booleanArray[point.getX()][point.getY()]) {
                booleanArray[point.getX()][point.getY()] = true;
                if (point.getX() != 0) {
                    searchAndMark(new Point(point.getX() - 1, point.getY()), board);
                }
                if (point.getX() != board.length - 1) {
                    searchAndMark(new Point(point.getX() + 1, point.getY()), board);
                }
                if (point.getY() != 0) {
                    searchAndMark(new Point(point.getX(), point.getY() - 1), board);
                }
                if (point.getY() != board[0].length - 1) {
                    searchAndMark(new Point(point.getX(), point.getY() + 1), board);
                }
            }
        }
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'X', 'O', 'X'},
                new char[]{'O', 'X', 'O'},
                new char[]{'X', 'O', 'X'}
        };
        Q130 q130 = new Q130();
        q130.solve(board);
        for (char[] charArray : board) {
            System.out.println(Arrays.toString(charArray));
        }

        for (boolean[] booleans : q130.booleanArray) {
            System.out.println(Arrays.toString(booleans));
        }
    }
}

