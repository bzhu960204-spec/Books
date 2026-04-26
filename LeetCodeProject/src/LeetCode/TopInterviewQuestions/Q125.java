package LeetCode.TopInterviewQuestions;

import java.util.*;
import java.util.regex.Pattern;

public class Q125 {
    /*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.

    Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.
    * */

    public boolean isPalindrome(String s) {
        char[] charSet = s.toLowerCase().toCharArray();
        ArrayDeque<Character> deque1 = new ArrayDeque<>();
        ArrayDeque<Character> deque2 = new ArrayDeque<>();
        for (char c : charSet) {
            if (Pattern.matches("[a-z0-9]", new String(new char[]{c}))) {
                deque1.add(c);
                deque2.add(c);
            }
        }
        while (deque1.size() > 0) {
            if (!deque1.pollFirst().equals(deque2.pollLast())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        s = s.toLowerCase();
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                charList.add(s.charAt(i));
            }
        }
        for (int i = 0; i < charList.size(); i++) {
            if (!charList.get(i).equals(charList.get(charList.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public boolean optimumSolutionFromInternet(String s) {
        // Use two pointer from left and right
        int left = 0;
        int right = s.length() - 1;
        char leftChar;
        char rightChar;

        // Scan from left and right to the middle
        while (left <= right) {
            // Update left and right char
            leftChar = s.charAt(left);
            rightChar = s.charAt(right);
            // Skip non-alphanumeric charcter
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                // Check if same char (ignoring cases)
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q125 q125 = new Q125();
        System.out.println(q125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
