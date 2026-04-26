package LeetCode.TopInterviewQuestions;

public class Q172 {

    public int trailingZeroes(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while (tmp % 10 == 0) {
                tmp /= 10;
                result++;
            }
            while (tmp % 5 == 0) {
                tmp /= 5;
                result++;
            }
        }
        return result;
    }
}
