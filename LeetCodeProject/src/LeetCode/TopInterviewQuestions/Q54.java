package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    /*

    Given an m x n matrix, return all elements of the matrix in spiral order.

    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        boolean[][] markMatrix = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        int startXindex = 0;
        int startYindex = 0;
        char directionFlag = 'r';
        while (count < matrix.length * matrix[0].length) {
            resultList.add(matrix[startXindex][startYindex]);
            markMatrix[startXindex][startYindex] = true;
            count++;
            if (directionFlag == 'r' && ((startYindex + 1) == matrix[0].length || markMatrix[startXindex][startYindex + 1])) {
                directionFlag = 'd';
                if (((startXindex + 1) == matrix.length || markMatrix[startXindex + 1][startYindex])) {
                    return resultList;
                }
            } else if (directionFlag == 'd' && ((startXindex + 1) == matrix.length || markMatrix[startXindex + 1][startYindex])) {
                directionFlag = 'l';

            } else if (directionFlag == 'l' && (startYindex  == 0 || markMatrix[startXindex][startYindex - 1])) {
                directionFlag = 'u';

            } else if (directionFlag == 'u' && (startXindex  == 0 || markMatrix[startXindex - 1][startYindex])) {
                directionFlag = 'r';
            }

            if (directionFlag == 'r') {
                startYindex++;
            } else if (directionFlag == 'd') {
                startXindex++;
            } else if (directionFlag == 'l') {
                startYindex--;
            } else if (directionFlag == 'u') {
                startXindex--;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Q54 q54 = new Q54();
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };
        System.out.println(q54.spiralOrder(matrix));
    }
}
