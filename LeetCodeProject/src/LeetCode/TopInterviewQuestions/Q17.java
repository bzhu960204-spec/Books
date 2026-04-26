package LeetCode.TopInterviewQuestions;

import java.util.*;

public class Q17 {

    /*
    Given a string containing digits from 2-9 inclusive,
    return all possible letter combinations that the number could represent.
    Return the answer in any order.

    A mapping of digits to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.
    */
    private static Map<Character, List<String>> numberCharacterMap = new HashMap<>() {{
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "o"));
        put('7', Arrays.asList("p", "q", "r", "s"));
        put('8', Arrays.asList("t", "u", "v"));
        put('9', Arrays.asList("w", "x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        if (digits.length() == 0) {
            return resultList;
        } else if (digits.length() == 1) {
            return numberCharacterMap.get(digits.charAt(0));
        } else {
            for (String s : letterCombinations(digits.substring(1))) {
                for (String ch : numberCharacterMap.get(digits.charAt(0))) {
                    resultList.add(ch + s);
                }
            }
            return resultList;
        }
    }

    public static void main(String[] args) {
        Q17 q17 = new Q17();
        System.out.println(q17.letterCombinations("2"));
    }
}
