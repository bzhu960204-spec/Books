package LeetCode.TopInterviewQuestions;

public class Q162 {

    /*
     A peak element is an element that is strictly greater than its neighbors.

    Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

    You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

    You must write an algorithm that runs in O(log n) time.

    */

    public static void main(String[] args) {
        Q162 q162 = new Q162();
        int[] array = new int[]{1};
        System.out.println(q162.findPeakElement(array));
    }

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] < 0) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
