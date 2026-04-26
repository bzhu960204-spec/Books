package LeetCode.TopInterviewQuestions;

public class Q29 {
    /*

    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

    The integer division should truncate toward zero, which means losing its fractional part.

    For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

    Return the quotient after dividing dividend by divisor.

    */

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        int result = 0;
        // 这块要转型为 long，调用 绝对值函数的时候 要先转型为 long
        long abs_Dividend = Math.abs((long) dividend);
        long abs_Divisor = Math.abs((long) divisor);
        while (abs_Dividend >= abs_Divisor) {
            int shift = 1;
            while (abs_Dividend >= (abs_Divisor << shift)) {
                shift++;
            }
            // result += (1 << shift) >> 1;
            // abs_Dividend -= (abs_Divisor << shift) >> 1;
            result += 1 << (shift - 1);
            abs_Dividend -= abs_Divisor << (shift - 1);
        }
        if (!flag) {
            return -result;
        }
        return result;
    }

    public static void main(String[] args) {
        Q29 q29 = new Q29();
//        System.out.println(q29.divide(-2147483648, 1));
//        System.out.println(1 << -1);
//        System.out.println(q29.time_exceededAnswer(2147483647, 1));
        System.out.println(2147483647 << 1 >>> 1);
    }

    // 原来是因为 没有转换为long 等等的原因
    // 误将 >> 错用为 >>>，后者是不带符号的，前者 如果是负数会在前面自动补1
    public int time_exceededAnswer(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        long result = 0;
        long abs_Dividend = Math.abs((long) dividend);
        long abs_Divisor = Math.abs((long) divisor);
        while (abs_Dividend > 0) {
            long tempDivisor = abs_Divisor;
            long tempResult = 1;
            while (abs_Dividend >= tempDivisor) {
                tempDivisor <<= 1;
                tempResult <<= 1;
            }
            result += tempResult >> 1;
            abs_Dividend -= tempDivisor >> 1;
        }
        if (!flag) {
            return -(int) result;
        }
        return (int) result;
    }
}
