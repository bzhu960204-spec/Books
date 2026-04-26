package LeetCode.TopInterviewQuestions;

import java.util.HashSet;

public class Q202 {

    /*

    Write an algorithm to determine if a number n is happy.

    A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.

    */

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            System.out.println(n);
            set.add(n);
            n = digitSum(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int digitSum(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }

    // two pointer solution
    public boolean twoPointer(int n) {
        int slow = n;
        int fast = digitSum(n);
        while (fast != 1) {
            slow = digitSum(slow);
            fast = digitSum(digitSum(fast));
            if (slow == fast) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q202 q202 = new Q202();
//        q202.isHappy(19);
        System.out.println(q202.digitSum(19));
    }
}
