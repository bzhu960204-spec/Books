package LeetCode.TopInterviewQuestions;

public class Q73 {
    /*

    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

    You must do it in place.

    */

    public void setZeroes(int[][] matrix) {
        int[][] matrixCopy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, matrixCopy[i], 0, matrix[i].length);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && matrixCopy[i][j] == 0) {
                    clearZero(matrix, i, j);
                }
            }
        }

    }

    public void clearZero(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[x][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }
    }
}
