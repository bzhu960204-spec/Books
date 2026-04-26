package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q22 {

    private List<String> result = new ArrayList<>();
    private StringBuilder temporaryResult = new StringBuilder();

    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    */
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, 2);
        return result;
    }

    public void backtrack(int left, int right, int n) {
        if (left == right && left == n) {
            result.add(temporaryResult.toString());
            return;
        }

        if (left <= n) {
            temporaryResult.append("(");
            backtrack(left + 1, right, n);
            temporaryResult.deleteCharAt(temporaryResult.length() - 1);
        }

        if (right < left) {
            temporaryResult.append(")");
            backtrack(left, right + 1, n);
            temporaryResult.deleteCharAt(temporaryResult.length() - 1);
        }
    }

    public static void main(String[] args) {
        Q22 q22 = new Q22();
        System.out.println(q22.generateParenthesis(1));
    }
}
