package LeetCode.TopInterviewQuestions;

import java.util.Stack;

public class Q20 {
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*/

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for (char c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    charStack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (charStack.size() == 0) {
                        return false;
                    } else {
                        Character character = charStack.pop();
                        if ((c == ')' && '(' != character) || (c == ']' && '[' != character) || (c == '}' && '{' != character)) {
                            return false;
                        }
                    }
            }
        }
        return charStack.size() == 0;
    }

    public static void main(String[] args) {
        Q20 q20 = new Q20();
        System.out.println(q20.isValid("()[]{}"));
    }
}
