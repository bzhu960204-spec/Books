package LeetCode.TopInterviewQuestions;

public class Q38 {
    /*

    The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

    countAndSay(1) = "1"
    countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
    To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

    For example, the saying and conversion for digit string "3322251":

    */

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return transformString(countAndSay(n - 1));
    }

    public String transformString(String input) {
        char[] charSet = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < charSet.length; i++) {
            if (i != 0 && charSet[i] != charSet[i - 1]) {
                result.append(count);
                result.append(charSet[i - 1]);
                count = 1;
            } else {
                count++;
            }
        }
        result.append(count);
        result.append(charSet[charSet.length - 1]);
        return result.toString();
    }

    public static void main(String[] args) {
        Q38 q38 = new Q38();
        System.out.println(q38.countAndSay(3));
    }
}
