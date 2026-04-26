package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            list.add(getRowIntegers(i));
        }
        return list;
    }

    private static List<Integer> getRowIntegers(int numRows) {
        List<Integer> returnList = new ArrayList<>();
        if (numRows < 3) {
            for (int i = 0; i < numRows; i++) {
                returnList.add(1);
            }
        } else {
            List<Integer> upList = getRowIntegers(numRows - 1);
            for (int i = 0; i < numRows; i++) {
                if (i > 0 && i < numRows - 1) {
                    returnList.add(upList.get(i - 1) + upList.get(i));
                } else if (i == 0) {
                    returnList.add(upList.get(i));
                } else {
                    returnList.add(upList.get(i - 1));
                }
            }
        }
        return returnList;
    }

    public List<List<Integer>> optimumAnswers(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arrayList.add(1);
                } else {
                    arrayList.add(returnList.get(i - 1).get(j - 1) + returnList.get(i - 1).get(j));
                }
            }
            returnList.add(arrayList);
        }
        return returnList;
    }

    public static void main(String[] args) {
        Q118 q188 = new Q118();
        System.out.println(q188.optimumAnswers(5));
    }
}
