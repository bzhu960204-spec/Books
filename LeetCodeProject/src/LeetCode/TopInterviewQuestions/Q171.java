package LeetCode.TopInterviewQuestions;

public class Q171 {
    /*
    Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
    For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
    */

    public int titleToNumber(String columnTitle) {
        int result = 0;
        char[] charArray = columnTitle.toCharArray();
        for (int i = 0; i < columnTitle.length(); i++) {
            if (i < columnTitle.length() - 1) {
                int digit = charArray[i] - 65;
                int previous = 1;
                for (int j = i; j < columnTitle.length() - 1; j++) {
                    digit *= 26;
                    previous *= 26;
                }
                result += digit;
                result += previous;
            } else {
                result += charArray[i] - 64;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q171 q171 = new Q171();
        System.out.println(q171.titleToNumber("A"));
    }
}
