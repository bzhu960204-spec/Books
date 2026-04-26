package LeetCode.TopInterviewQuestions;

import java.util.Arrays;

public class Q34 {
    /*
    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    You must write an algorithm with O(log n) runtime complexity.
    */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public int[] searchRange_ONlgN(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{binarySearch_SearchRangeLeft(nums, 0, nums.length - 1, target),
                binarySearch_SearchRangeRight(nums, 0, nums.length - 1, target)};
    }

    public int binarySearch_SearchRangeLeft(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            int findLeft = binarySearch_SearchRangeLeft(nums, left, mid - 1, target);
            return findLeft == -1 ? mid : findLeft;
        } else if (nums[mid] < target) {
            return binarySearch_SearchRangeLeft(nums, mid + 1, right, target);
        } else {
            return binarySearch_SearchRangeLeft(nums, left, mid - 1, target);
        }
    }

    public int binarySearch_SearchRangeRight(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            int findRight = binarySearch_SearchRangeRight(nums, mid + 1, right, target);
            return findRight == -1 ? mid : findRight;
        } else if (nums[mid] < target) {
            return binarySearch_SearchRangeRight(nums, mid + 1, right, target);
        } else {
            return binarySearch_SearchRangeRight(nums, left, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        Q34 q34 = new Q34();
        int[] arrays = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(q34.searchRange_ONlgN(arrays, 8)));
    }
}
