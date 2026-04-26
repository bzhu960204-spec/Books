package LeetCode.TopInterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q139 {
    /*
    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.
    */

    boolean[] booleans;

    public boolean wordBreak_mySolution(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        booleans = new boolean[chars.length];
//        wordDict.sort(Comparator.comparing(String::length).reversed());
//        System.out.println(wordDict);
//        return false;
        return searchInStringList(chars, 0, wordDict);
    }

    public boolean searchInStringList(char[] charArray, int startIndex, List<String> wordDict) {
        if (startIndex == charArray.length) {
            return true;
        }
        if (booleans[startIndex]) {
            return false;
        }
        for (String s : wordDict) {
            char[] searchCharArray = s.toCharArray();
            if (judgeEqual(charArray, searchCharArray, startIndex)) {
                boolean flag = searchInStringList(charArray, startIndex + searchCharArray.length, wordDict);
                if (flag) {
                    return true;
                }
            }
        }
        if (booleans[startIndex]) {
            booleans[startIndex] = true;
        }
        return false;
    }

    boolean judgeEqual(char[] charArray, char[] charArray2, int startIndex) {
        if (charArray2.length + startIndex > charArray.length) {
            return false;
        }
        for (int i = 0; i < charArray2.length; i++) {
            if (charArray2[i] != charArray[startIndex + i]) {
                return false;
            }
        }
        return true;
    }

    boolean[] dp;

    public boolean wordBreak_OnlineSolution(String s, List<String> wordDict) {
        dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String str : wordDict) {
                if (i + str.length() <= s.length() && s.startsWith(str, i)) {
                    dp[i] = dp[i + str.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }

    public boolean wordBreak_ReverseSolution(String s, List<String> wordDict) {
        dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String str : wordDict) {
                if (i - str.length() >= 0 && s.startsWith(str, i - str.length())) {
                    dp[i] = dp[i - str.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Q139 q139 = new Q139();
//        System.out.println(q139.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}
