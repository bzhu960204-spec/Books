package LeetCode.TopInterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q283 {
    /*

    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    */

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
//        int[] resultArray = new int[nums.length];
//        int j = 0;
//        for (int i : nums) {
//            if (i > 0) {
//                resultArray[j++] = i;
//            }
//        }
    }
}
