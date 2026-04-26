package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q7 {
    /*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value
    to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    */
    public int reverse(int x) {
        int result = 0;
        List<Integer> integerList = new ArrayList<>();
        int digit;
        do {
            digit = x % 10;
            x /= 10;
            integerList.add(digit);
        } while (x != 0);

        for (Integer integer : integerList) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && integer > 7) ||
                    result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && integer < -8)) {
                return 0;
            }
            result *= 10;
            result += integer;
        }

        return result;
    }

    public static void main(String[] args) {
        Q7 q7 = new Q7();
        System.out.println(q7.reverse(-123));
//        System.out.println(Integer.MIN_VALUE);
    }
}
