package LeetCode.TopInterviewQuestions;

public class Q70 {

    /*
    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    */
    public int climbStairs(int n) {
        int pre = 1;
        int current = 1;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp = pre;
            pre = current;
            current = current + pre;
        }
        return current;
    }

    public static void main(String[] args) {

    }
}
