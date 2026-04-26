package LeetCode.TopInterviewQuestions;

public class Q28 {
    /*
    Implement strStr().

    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Clarification:

    What should we return when needle is an empty string? This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

    */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        char[] needleChars = needle.toCharArray();
        char[] hayStackChars = haystack.toCharArray();
        for (int i = 0; i < hayStackChars.length; i++) {
            for (int j = 0; j < needleChars.length; j++) {
                if ((i + j) == hayStackChars.length || needleChars[j] != hayStackChars[i + j]) break;
                if ((needleChars[j] == hayStackChars[i + j]) && (j == needleChars.length - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Q28 q28 = new Q28();
        String str1 = "mississippi";
        String str2 = "issipi";
        System.out.println(q28.strStr(str1, str2));
    }

}
