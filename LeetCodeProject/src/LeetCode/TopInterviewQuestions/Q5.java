package LeetCode.TopInterviewQuestions;

public class Q5 {
    /*
    Given a string s, return the longest palindromic substring in s.

    */
    public String longestPalindrome(String s) {
        int length = s.length();
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < length - i + 1; j++) {
                String s1 = s.substring(j, j + i);
                if (jdugePalidrome(s1)) {
                    return s1;
                }
            }
        }
        return "";
    }

    public boolean jdugePalidrome(String s) {
        char[] charSet = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (charSet[i++] != charSet[j--]) {
                return false;
            }
        }
        return true;
    }

    public String onlineSolution(String s) {
        char[] charSet = s.toCharArray();
        int maxLength = 0;
        String resultString = "";
        // odd palindrome
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length()) {
                if (charSet[l] == charSet[r]) {
                    if ((r - l + 1) > maxLength) {
                        maxLength = r - l + 1;
                        resultString = s.substring(l, r + 1);
                    }
                } else {
                    break;
                }
                l--;
                r++;
            }
        }

        // even palindrome
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (charSet[l] == charSet[r]) {
                    if ((r - l + 1) > maxLength) {
                        maxLength = r - l + 1;
                        resultString = s.substring(l, r + 1);
                    }
                } else {
                    break;
                }
                l--;
                r++;
            }
        }
        return resultString;
    }

    public static void main(String[] args) {
        Q5 q5 = new Q5();
        System.out.println(q5.onlineSolution("babad"));
    }
}
