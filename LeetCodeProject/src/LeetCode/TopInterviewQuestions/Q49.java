package LeetCode.TopInterviewQuestions;

import java.util.*;

public class Q49 {

    /*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    */

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        int[] charNumber;
        for (String str : strs) {
            charNumber = new int[26];
            char[] charSet = str.toCharArray();
            for (char c : charSet) {
                charNumber[c - 'a']++;
            }
            // when retrieving from a HashMap using String as key can be very efficient
            if (resultMap.containsKey(Arrays.toString(charNumber))) {
                resultMap.get(Arrays.toString(charNumber)).add(str);
            } else {
                List<String> arrayList = new ArrayList<>() {{
                    add(str);
                }};
                resultMap.put(Arrays.toString(charNumber), arrayList);
            }

        }
        return new ArrayList<>(resultMap.values());
    }

    public List<List<String>> groupAnagramsHash(String[] strs) {
        Map<Integer, List<String>> resultMap = new HashMap<>();
        int[] charNumber;
        for (String str : strs) {
            charNumber = new int[26];
            char[] charSet = str.toCharArray();
            for (char c : charSet) {
                charNumber[c - 'a']++;
            }
            // when retrieving from a HashMap using String as key can be very efficient
            int hashCode = Arrays.toString(charNumber).hashCode();
            if (resultMap.containsKey(hashCode)) {
                resultMap.get(hashCode).add(str);
            } else {
                List<String> arrayList = new ArrayList<>() {{
                    add(str);
                }};
                resultMap.put(hashCode, arrayList);
            }

        }
        return new ArrayList<>(resultMap.values());
    }

    public List<List<String>> groupAnagramsUsingPrimes(String[] strs) {
        Map<Long, List<String>> resultMap = new HashMap<>();
        int[] primeArray = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (String str : strs) {
            // 防止越界问题
            // 即使用long 仍然无法避免越界问题 因为 long 只有32位，而乘积很容易超越这个值
            long key = 1;
            char[] charSet = str.toCharArray();
            for (char c : charSet) {
                key *= primeArray[c - 'a'];
                System.out.println(key);
            }
            System.out.println(key);
            if (resultMap.containsKey(key)) {
                resultMap.get(key).add(str);
            } else {
                List<String> arrayList = new ArrayList<>() {{
                    add(str);
                }};
                resultMap.put(key, arrayList);
            }

        }
        return new ArrayList<>(resultMap.values());
    }

    public static void main(String[] args) {
        Q49 q49 = new Q49();
        String[] strs = new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"};
        System.out.println(q49.groupAnagramsHash(strs));
    }
}
