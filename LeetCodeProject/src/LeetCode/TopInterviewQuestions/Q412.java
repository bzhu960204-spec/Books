package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q412 {

    /*
    Given an integer n, return a string array answer (1-indexed) where:

    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.
    */

    public List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                resultList.add("FizzBuzz");
            } else if ((i + 1) % 3 == 0) {
                resultList.add("Fizz");
            } else if ((i + 1) % 5 == 0) {
                resultList.add("Buzz");
            } else {
                resultList.add(String.valueOf(i + 1));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Q412 q412 = new Q412();
        System.out.println(q412.fizzBuzz(3));
    }
}
