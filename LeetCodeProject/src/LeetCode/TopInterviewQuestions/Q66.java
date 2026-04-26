package LeetCode.TopInterviewQuestions;

import java.util.Arrays;

public class Q66 {
    /*
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.

    The digits are ordered from most significant to least significant in left-to-right order.

    The large integer does not contain any leading 0's.

    Increment the large integer by one and return the resulting array of digits.

    Constraints:

    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.

    */

    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == 0 && digits[i] == 9 && carry) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }
            if (carry) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    carry = false;
                }
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{8,9};
        Q66 q66 = new Q66();
        System.out.println(Arrays.toString(q66.plusOne(inputArray)));
    }
}
