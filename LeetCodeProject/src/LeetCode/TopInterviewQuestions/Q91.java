package LeetCode.TopInterviewQuestions;

import java.util.Arrays;

/**
 * 非最佳解
 */
public class Q91 {
    /*
    To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

    "AAJF" with the grouping (1 1 10 6)
    "KJF" with the grouping (11 10 6)
    Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

    Given a string s containing only digits, return the number of ways to decode it.

    The test cases are generated so that the answer fits in a 32-bit integer.
    */

    /*
    10 20 只有一种解码方式 所以不影响总的解码数
    11-19 两种解码方式
    21-26 两种解码方式
    0,3-9 后面不能跟其他值
    0 必须和前面的跟在一起
    */
    char[] charArray;
    int resultCount;

    public int numDecodings(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 0 || charArray[0] == '0') {
            return 0;
        }
        int[] decode = new int[charArray.length];

        decode[0] = 1;
        if (charArray.length == 1) {
            return decode[0];
        }

        if (charArray[1] == '0' && (charArray[0] > '2' || charArray[0] < '1')) {
            return 0;
        }

        if (charArray[0] > '2' ||
                (charArray[0] == '2' && charArray[1] > '6') ||
                charArray[1] == '0' ||
                (charArray.length > 2 && charArray[2] == '0')) {
            decode[1] = 1;
        } else {
            decode[1] = 2;
        }

        for (int index = 2; index < decode.length; index++) {
            if (charArray[index] == '0' && (charArray[index - 1] > '2' || charArray[index - 1] < '1')) {
                return 0;
            }
            if (charArray[index - 1] > '2' || (charArray[index - 1] == '2' && charArray[index] > '6') || charArray[index - 1] == '0' || (charArray.length > index + 1 && charArray[index + 1] == '0')) {
                decode[index] = decode[index - 1];
            } else if (charArray[index] == '0') {
                decode[index] = decode[index - 2];
            } else {
                decode[index] = decode[index - 1] + decode[index - 2];
            }
        }
        System.out.println(Arrays.toString(decode));
        return decode[charArray.length - 1];
    }

    public void decode(int decodeIndex) {
        if (decodeIndex == charArray.length) {
            resultCount++;
        } else {
            if (charArray[decodeIndex] > '2') {
                decode(decodeIndex + 1);
                return;
            }
            if (decodeIndex + 1 < charArray.length) {
                if (charArray[decodeIndex + 1] == '0') {
                    decode(decodeIndex + 2);
                } else if ((charArray[decodeIndex] == '1') || (charArray[decodeIndex] == '2' && charArray[decodeIndex + 1] < '7')) {
                    decode(decodeIndex + 1);
                    decode(decodeIndex + 2);
                } else {
                    decode(decodeIndex + 1);
                }
            } else {
                decode(decodeIndex + 1);
            }
        }
    }

    public static void main(String[] args) {
        Q91 q91 = new Q91();
        System.out.println(q91.numDecodings("10011"));
        q91.resultCount = 0;
//        System.out.println(q91.numDecodings("226"));
//        q91.resultCount = 0;
//        System.out.println(q91.numDecodings("06"));
    }
}
