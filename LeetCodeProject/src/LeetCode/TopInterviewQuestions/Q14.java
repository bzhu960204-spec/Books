package LeetCode.TopInterviewQuestions;

import java.util.*;

public class Q14 {

/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

* */

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        List<String> stringList = new ArrayList<>(Arrays.asList(strs));
        stringList.sort((str1, str2) -> str1.length() >= str2.length() ? 1 : -1);
        do {
            String str1 = stringList.remove(0);
            String str2 = stringList.remove(0);
            StringBuilder commonPrefix = new StringBuilder();
            int shorterLength = Math.min(str1.length(), str2.length());
            for (int i = 0; i < shorterLength; i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    commonPrefix.append(str1.charAt(i));
                } else {
                    break;
                }
            }
            stringList.add(0, commonPrefix.toString());
        } while (stringList.size() >= 2);
        return stringList.get(0);
    }

//    public String returnCommonPrefix(String first, String second) {
//        StringBuilder commonPrefix = new StringBuilder();
//        int shorterLength = Math.min(first.length(), second.length());
//        for (int i = 0; i < shorterLength; i++) {
//            if (first.charAt(i) == second.charAt(i)) {
//                commonPrefix.append(i);
//            }
//        }
//        return commonPrefix.toString();
//    }

    public static void main(String[] args) {
        String[] newString = new String[]{"cir","car"};
        Q14 q14 = new Q14();
        System.out.println(q14.longestCommonPrefix(newString));
    }
}
