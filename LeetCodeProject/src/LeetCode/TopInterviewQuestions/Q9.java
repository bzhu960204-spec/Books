package LeetCode.TopInterviewQuestions;

public class Q9 {
    /*
    Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.​​​​
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).

    */
    public boolean isMatch(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        Q9 q9 = new Q9();
        System.out.println(q9.isMatch("", ""));
    }

    public boolean officialSolution(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (officialSolution(text, pattern.substring(2)) ||
                    (first_match && officialSolution(text.substring(1), pattern)));
        } else {
            return first_match && officialSolution(text.substring(1), pattern.substring(1));
        }
    }
}
