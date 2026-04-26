package LeetCode.TopInterviewQuestions;

/**
 * currMin 只是一个辅助值
 */
public class Q152 {
    /*

     Given an integer array nums, find a
     subarray
     that has the largest product, and return the product.

     The test cases are generated so that the answer will fit in a 32-bit integer.

     */

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maximumProduct = nums[0];
        int currMax = 1;
        int currMin = 1;
        for (int num : nums) {
            if (num == 0) {
                if (0 > maximumProduct) {
                    maximumProduct = 0;
                }
                currMax = 1;
                currMin = 1;
                continue;
            }
            int tmp = currMax * num;
            currMax = currMax * num > currMin * num ? Math.max(currMax * num, num) : Math.max(currMin * num, num);
            currMin = tmp > currMin * num ? Math.min(currMin * num, num) : Math.min(tmp, num);
            maximumProduct = Math.max(currMax,maximumProduct);
        }
        return maximumProduct;
    }
}
