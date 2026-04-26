package LeetCode.TopInterviewQuestions;

import java.util.HashMap;

public class Q242 {
    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    */

    public boolean isAnagram(String s, String t) {
        char[] charSet = s.toCharArray();
        char[] charSet2 = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : charSet) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : charSet2) {
            if (!map.containsKey(c)) {
                return false;
            } else if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return map.size() == 0;
    }
}
