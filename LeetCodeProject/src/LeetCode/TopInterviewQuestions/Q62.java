package LeetCode.TopInterviewQuestions;

public class Q62 {
    /*
    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

    Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

    The test cases are generated so that the answer will be less than or equal to 2 * 109.
    */
    static int[][] intArray;

    public int uniquePaths(int m, int n) {
        intArray = new int[m][n];
        boolean flag = m >= n;
        return uniquePaths_1(m, n, flag);
    }

    public int uniquePaths_1(int m, int n, boolean flag) {
//        if (m == 2 && n == 1) return 1;
//        if (m == 1 && n == 2) return 1;
        if (m == 1) return 1;
        if (n == 1) return 1;
        if ((flag && m < n) || (!flag && m > n)) return uniquePaths_1(n, m, flag);
        if (intArray[m - 2][n - 1] == 0) {
            intArray[m - 2][n - 1] = uniquePaths_1(m - 1, n, flag);
        }
        if (intArray[m - 1][n - 2] == 0) {
            intArray[m - 1][n - 2] = uniquePaths_1(m, n - 1, flag);
        }
        return intArray[m - 2][n - 1] + intArray[m - 1][n - 2];
    }

    public static void main(String[] args) {
        Q62 q62 = new Q62();
        System.out.println(q62.uniquePaths(3, 7));
    }
}
