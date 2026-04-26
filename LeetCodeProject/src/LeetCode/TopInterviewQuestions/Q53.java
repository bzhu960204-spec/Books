package LeetCode.TopInterviewQuestions;

public class Q53 {
    /*

    Given an integer array nums, find the
    subarray
    which has the largest sum and return its sum.

    */

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
