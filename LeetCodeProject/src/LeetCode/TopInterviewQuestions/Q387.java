package LeetCode.TopInterviewQuestions;

import java.util.HashMap;

public class Q387 {
    /*

    Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

    */
    public int firstUniqChar(String s) {
        if (s == null) return -1;
        char[] chars = s.toCharArray();
        int min = s.length() - 1;
        boolean flag = true;
        HashMap<Character, Integer> charIntegerMap = new HashMap<>();
        for (char c : chars) {
            charIntegerMap.put(c, charIntegerMap.getOrDefault(c, 0) + 1);
        }

        // the following code is redundant,
        // it could be replaced foreach the char in String and use the char to get the first element in Map of which the value is 1
        for (char a : charIntegerMap.keySet()) {
            if (charIntegerMap.get(a) == 1) {
                if (s.indexOf(a) < min) {
                    min = s.indexOf(a);
                }
                flag = false;
            }
        }
        if (flag) return -1;

        return min;
    }

    public int onlineSolutions(){
        return 0;
    }
}
