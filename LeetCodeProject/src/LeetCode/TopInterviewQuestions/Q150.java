package LeetCode.TopInterviewQuestions;

import java.util.Stack;
import java.util.regex.Pattern;

public class Q150 {

    /*
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

    Evaluate the expression. Return an integer that represents the value of the expression.

    Note that:

    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.

    */
    public static void main(String[] args) {
        String[] strs = new String[]{"2", "1", "+", "3", "*"};
        String[] strs1 = new String[]{"4","13","5","/","+"};
        String[] strs2 = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Q150 q150 = new Q150();
        System.out.println(q150.evalRPN(strs));
        System.out.println(q150.evalRPN(strs1));
        System.out.println(q150.evalRPN(strs2));
    }

    public int evalRPN(String[] tokens) {
        String regexPattern = "-?\\d+";
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.matches(regexPattern)) {
                stack.push(Integer.parseInt(str));
            } else {
                Integer operator1 = stack.pop();
                Integer operator2 = stack.pop();
                int result = 0;
                switch (str) {
                    case "*" -> result = operator1 * operator2;
                    case "+" -> result = operator1 + operator2;
                    case "-" -> result = operator2 - operator1;
                    case "/" -> result = operator2 / operator1;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
