package LeetCode.TopInterviewQuestions;

public class Q55 {
    /*
    You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.
    */
    public boolean canJump(int[] nums) {
        return helper(nums, nums.length - 1);
    }

    public boolean helper(int[] nums, int target) {
        if (target == 0) return true;
        for (int i = 0; i < target; i++) {
            if (target - i <= nums[i]) {
                return helper(nums, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q55 q55 = new Q55();
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(q55.canJump(nums));
    }
}
