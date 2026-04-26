package LeetCode.TopInterviewQuestions;

import java.util.Arrays;

public class Q128 {
    /*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

    You must write an algorithm that runs in O(n) time.
    */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longestConsecutiveLength = 1;
        int currentConsecutiveLength = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                currentConsecutiveLength += 1;
            } else {
                if (currentConsecutiveLength > longestConsecutiveLength) {
                    longestConsecutiveLength = currentConsecutiveLength;
                }
                currentConsecutiveLength = 1;
            }
        }
        return Math.max(currentConsecutiveLength, longestConsecutiveLength);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Q128 q128 = new Q128();
        System.out.println(q128.longestConsecutive(nums));
    }
}
