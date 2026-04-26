package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q8 {
    /*
    *
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
    * */
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        List<Integer> digitsList = new ArrayList<>();
        s = s.trim();
        int result = 0;
        boolean flag = true;
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            flag = false;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        while (s.length() != 0 && s.charAt(0) == '0') {
            s = s.substring(1);
        }
        for (char c : s.toCharArray()) {
            if ("0123456789".indexOf(c) == -1) {
                break;
            }
            digitsList.add(Integer.valueOf(String.valueOf(c)));
        }
        if (digitsList.size() == 0) {
            return 0;
        }
        for (int i : digitsList) {
            if (flag) {
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && i > 7)) {
                    return Integer.MAX_VALUE;
                }
                result *= 10;
                result += i;
            } else {
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && i > 8)) {
                    return Integer.MIN_VALUE;
                }
                result *= 10;
                result -= i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q8 q8 = new Q8();
//        System.out.println(q8.myAtoi("-2147483648"));
        System.out.println(q8.officialSolution("-2147483648"));
    }

    public int officialSolution(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();

        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < n && input.charAt(index) == '+') {
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }
}
