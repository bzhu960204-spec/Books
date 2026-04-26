package LeetCode.TopInterviewQuestions;

public class Q69 {
    /*

    Given a non-negative integer x, compute and return the square root of x.

    Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

    Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

    */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int result = 2;
        int square;
        while ((square = result * result) <= x) {
            if (square < 0) {
                break;
            }
            result += 1;
        }
        return result - 1;
    }

    public int mySqrt1(int x) {
        long start = 0;
        long end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end == x) {
            return (int)end;
        }
        return (int)start;
    }

    public static void main(String[] args) {
        Q69 q69 = new Q69();
        System.out.println(q69.mySqrt(2147395600));
    }
}
