package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 非最佳
 */
public class Q79 {
    /*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
    */
    private boolean[][] used;

    public boolean exist(char[][] board, String word) {
        List<Point> pointList = IntStream
                .range(0, board.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, board[0].length).mapToObj(j -> new Point(i, j)))
                .toList();
        used = new boolean[board.length][board[0].length];
        char[] requiredChar = word.toCharArray();
        return existInRange(board, pointList, requiredChar, 0);
    }


    public boolean existInRange(char[][] board, List<Point> pointRange, char[] charArray, int index) {
        for (Point p : pointRange) {
            if (board[p.getX()][p.getY()] == charArray[index] && !used[p.getX()][p.getY()]) {
                if (index == charArray.length - 1) {
                    return true;
                } else {
                    used[p.getX()][p.getY()] = true;
                    List<Point> pointRange2 = new ArrayList<>();
                    if (p.getX() + 1 < board.length) {
                        pointRange2.add(new Point(p.getX() + 1, p.getY()));
                    }
                    if (p.getX() - 1 >= 0) {
                        pointRange2.add(new Point(p.getX() - 1, p.getY()));
                    }
                    if (p.getY() + 1 < board[0].length) {
                        pointRange2.add(new Point(p.getX(), p.getY() + 1));
                    }
                    if (p.getY() - 1 >= 0) {
                        pointRange2.add(new Point(p.getX(), p.getY() - 1));
                    }
                    boolean flag = existInRange(board, pointRange2, charArray, index + 1);
                    if (!flag) {
                        used[p.getX()][p.getY()] = false;
                    } else {
                        return flag;
                    }
//                    return flag;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'},
        };
        Q79 q79 = new Q79();
        System.out.println(q79.exist(board, "SEE"));
//        char[][] board = new char[2][2];
//        List<Point> pointList = IntStream
//                .range(0, board.length)
//                .boxed()
//                .flatMap(i -> IntStream.range(0, board[0].length).mapToObj(j -> new Point(i, j)))
//                .toList();
//        System.out.println(pointList);
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
