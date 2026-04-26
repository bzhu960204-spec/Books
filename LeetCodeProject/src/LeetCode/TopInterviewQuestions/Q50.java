package LeetCode.TopInterviewQuestions;

public class Q50 {
    // Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

    // linear time complexity couldn't pass the test case, need to use recursion
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double result = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result *= x;
            }
        } else {
            for (int i = 0; i < -n; i++) {
                result /= x;
            }
        }
        return result;
    }

    public double myPow_recursion(double x, int n) {
        return helperRecursion(x, n);
    }

    public double helperRecursion(double x, long n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        if (n == 1) return x;
        double result = helperRecursion(x * x, Math.abs(n) / 2);
        if (n % 2 != 0) {
            result = result * x;
        }
        if (n > 0) {
            return result;
        } else {
            return 1 / result;
        }
    }

    public double myPow_OnlineSolution1(double x, int n) {
        return online_Helper(x, n);
    }

    public double online_Helper(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / online_Helper(x, -n);
        if (n % 2 == 1)
            return x * online_Helper(x, n - 1);
        return online_Helper(x * x, n / 2);
    }


    public static void main(String[] args) {
        Q50 q50 = new Q50();
        System.out.println(q50.myPow_recursion(2, 2147483647));
        System.out.println(q50.myPow_OnlineSolution1(2, 2147483647));
    }
}
