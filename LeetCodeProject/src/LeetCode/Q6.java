package LeetCode;

public class Q6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        int groupLength = numRows + numRows - 2;

        int groupNum;
        if (length % groupLength == 0) {
            groupNum = length / groupLength;
        } else {
            groupNum = length / groupLength + 1;
        }


        char[][] twoDimensionArray = new char[groupNum][groupLength];

        int charIndex = 0;
        for (int i = 0; i < groupNum; i++) {
            for (int j = 0; j < groupLength && charIndex < s.length(); j++) {
                twoDimensionArray[i][j] = s.charAt(charIndex);
                charIndex++;
            }
        }
        StringBuilder result = new StringBuilder();
        int lineNumber = (groupLength + 2) / 2;
        for (int i = 0; i < lineNumber; i++) {
            if (i == 0) {
                for (int j = 0; j < groupNum; j++) {
                    result.append(twoDimensionArray[j][0]);
                }
            } else if (i == lineNumber - 1) {
                for (int j = 0; j < groupNum; j++) {
                    if (twoDimensionArray[j][lineNumber - 1] != 0) {
                        result.append(twoDimensionArray[j][lineNumber - 1]);
                    }
                }
            } else {
                for (int j = 0; j < groupNum; j++) {
                    if (twoDimensionArray[j][i] != 0) {
                        result.append(twoDimensionArray[j][i]);
                    }
                    if (twoDimensionArray[j][groupLength - i] != 0) {
                        result.append(twoDimensionArray[j][groupLength - i]);
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Q6 q6 = new Q6();
        System.out.println(q6.convert("A", 1));
    }
}
