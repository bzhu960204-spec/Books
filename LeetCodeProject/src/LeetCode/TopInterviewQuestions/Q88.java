package LeetCode.TopInterviewQuestions;

import java.util.Arrays;

public class Q88 {
    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function,
    but instead be stored inside the array nums1.
    To accommodate this, nums1 has a length of m + n,
    where the first m elements denote the elements that should be merged,
    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums1.length ; i++) {
            if (m == 0) {
                nums1[nums1.length - 1 - i] = nums2[n - 1];
                n--;
            } else if (n == 0) {
                nums1[nums1.length - 1 - i] = nums1[m - 1];
                m--;
            } else {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[nums1.length - 1 - i] = nums1[m - 1];
                    m--;
                } else {
                    nums1[nums1.length - 1 - i] = nums2[n - 1];
                    n--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q88 q88 = new Q88();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        q88.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
