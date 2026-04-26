package LeetCode.TopInterviewQuestions;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 1;
        int maxLength = 0;
        for (end = 1; end < s.length(); end++) {
            int indexOfNextChar = s.substring(start, end).indexOf(s.charAt(end));
            if (indexOfNextChar != -1) {
                if ((end - start) > maxLength) {
                    maxLength = end - start;
                }
                start = start + indexOfNextChar + 1;
            }
        }

        if ((end - start) > maxLength) {
            maxLength = end - start;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.lengthOfLongestSubstring("abcaaaaabcde"));
    }
}
