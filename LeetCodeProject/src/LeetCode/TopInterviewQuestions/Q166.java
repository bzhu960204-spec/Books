package LeetCode.TopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class Q166 {
    /*
    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

    If the fractional part is repeating, enclose the repeating part in parentheses.

    If multiple answers are possible, return any of them.

    It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
    */

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        if (numerator > 0 ^ denominator > 0) {
            result.append("-");
        }
        // Math abs return long when the input is of type long
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long quotient = num / den;
        result.append(quotient);
        long remainder = (num % den) * 10;
        if (remainder == 0) {
            return result.toString();
        } else {
            Map<Long, Integer> remainderMap = new HashMap<>();
            result.append(".");
            while (remainder != 0) {
                if (remainderMap.containsKey(remainder)) {
                    result.insert(remainderMap.get(remainder), "(");
                    result.append(")");
                    return result.toString();
                }
                remainderMap.put(remainder, result.length());
                quotient = remainder / den;
                result.append(quotient);
                remainder = (remainder % den) * 10;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Double.toString((long) 2 / 1));
    }
}
