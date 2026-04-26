package LeetCode.TopInterviewQuestions;

import java.util.Arrays;

public class Q48 {
    /*
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.s
    */
    public void rotate(int[][] matrix) {
        int dimension = matrix.length;
        boolean[][] marks = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (marks[i][j]) {
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[dimension - 1 - j][i];
                matrix[dimension - 1 - j][i] = matrix[dimension - 1 - i][dimension - 1 - j];
                matrix[dimension - 1 - i][dimension - 1 - j] = matrix[j][dimension - 1 - i];
                matrix[j][dimension - 1 - i] = temp;
                marks[i][j] = true;
                marks[dimension - 1 - j][i] = true;
                marks[dimension - 1 - i][dimension - 1 - j] = true;
                marks[j][dimension - 1 - i] = true;
            }
        }
    }

//    public String findNextLocation(int x, int y, int arrayDimension) {
//        return y + " " + (arrayDimension - 1 - x);
//    }


    public static void main(String[] args) {
        Q48 q48 = new Q48();
        int[][] array = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };
        q48.rotate(array);
        for (int[] i : array) {
            System.out.println(Arrays.toString(i));
        }
    }

}
