package LeetCodeBook;

public class ReverseWordsInAString {

    /*
    Question:
    Given an input string s, reverse the string word by word.
    For example, given s = "the sky is blue", return "blue is sky the".
    Example Questions Candidate Might Ask:
    Q: What constitutes a word?
    A: A sequence of non-space characters constitutes a word.
    Q: Does tab or newline character count as space characters?
    A: Assume the input does not contain any tabs or newline characters.
    Q: Could the input string contain leading or trailing spaces?
    A: Yes. However, your reversed string should not contain leading or trailing spaces.
    Q: How about multiple spaces between two words?
    A: Reduce them to a single space in the reversed string.
    */

    private String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(" ");
                }
                reversed.append(s, i, j);
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String a = "  hello I am Bob  ";
        ReverseWordsInAString rs = new ReverseWordsInAString();
        System.out.println(rs.reverseWords(a));
    }
}
