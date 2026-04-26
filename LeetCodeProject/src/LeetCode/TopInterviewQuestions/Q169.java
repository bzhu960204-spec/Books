package LeetCode.TopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class Q169 {
    /*
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
    */

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i : nums) {
            if (numsMap.containsKey(i)) {
                if ((numsMap.get(i) + 1) > nums.length / 2) {
                    return i;
                }
                numsMap.put(i, numsMap.get(i) + 1);
            } else {
                numsMap.put(i, 1);
            }
        }
        return -1;
    }

    public int optimumSolution(int[] nums) {
        int res = 0;
        int max = 0;
        for (int i : nums) {
            if (max == 0) {
                res = i;
            }
            if (i == res) {
                max++;
            } else {
                max--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
