package LeetCode.TopInterviewQuestions;

import java.util.Arrays;

public class Q33 {
    /*
    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.

    */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search_OLogN(int[] nums, int target) {
        return binarySearchRotate(nums, 0, nums.length - 1, target);
    }

    public int binarySearchRotate(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        // 这里 等于的情况归于左边的情况
        // 写这个程序的关键在于 搞清边界情况 boundary cases
        if (nums[mid] >= nums[left]) {
            if (target > nums[mid]) {
                return binarySearchRotate(nums, mid + 1, right, target);
            } else {
                if (target >= nums[left]) {
                    return binarySearchRotate(nums, left, mid - 1, target);
                } else {
                    return binarySearchRotate(nums, mid + 1, right, target);
                }
            }
        } else {
            if (target < nums[mid]) {
                return binarySearchRotate(nums, left, mid - 1, target);
            } else {
                if (target > nums[right]) {
                    return binarySearchRotate(nums, left, mid - 1, target);
                } else {
                    return binarySearchRotate(nums, mid + 1, right, target);
                }
            }
        }
    }

    public static void main(String[] args) {
        Q33 q33 = new Q33();
        int[] array = new int[]{1, 3, 5};
        System.out.println(q33.search_OLogN(array, 1));
    }
}
