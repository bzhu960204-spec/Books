package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q131 {
    List<List<String>> resultList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        partition(s, new ArrayList<>());
        return resultList;
    }

    void partition(String remainString, List<String> previousResult) {
        for (int i = 1; i <= remainString.length(); i++) {
            String thisPartrition = remainString.substring(0, i);
            if (isPalindrome(thisPartrition)) {
                List<String> copyStringArray = new ArrayList<>(previousResult);
                copyStringArray.add(thisPartrition);
                if (i < remainString.length()) {
                    partition(remainString.substring(i), copyStringArray);
                } else {
                    resultList.add(copyStringArray);
                }
            }
        }
    }

    boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

    public static void main(String[] args) {
        Q131 q131 = new Q131();
        List<List<String>> resultList = q131.partition("aab");
        for (List<String> strings : resultList) {
            System.out.println(strings);
        }
    }
}
