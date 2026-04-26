package LeetCode.TopInterviewQuestions;

import java.util.Arrays;
import java.util.HashSet;

public class Q268 {

    /*
    Given an array nums containing n distinct numbers in the range [0, n],

    return the only number in the range that is missing from the array.
    */

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i + 1];
            }
        }
        return -1;
    }

    public int hashsetApproach(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
