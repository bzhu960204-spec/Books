package LeetCode.TopInterviewQuestions;

import java.util.*;

public class Q350 {
    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection.

    Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
    */
    public int[] intersect_Approach1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect_Approach1(nums2, nums1);
        }
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : nums1) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (int value : nums2) {
            if (map.getOrDefault(value, 0) > 0) {
                resultList.add(value);
                map.put(value, map.get(value) - 1);
            }
        }

        int[] result = new int[resultList.size()];
        int j = 0;
        for (int i : resultList) {
            result[j++] = i;
        }
        return result;
    }

    public int[] intersect_Approach2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] resultArray = new int[result.size()];
        i = 0;
        for (int element : result) {
            resultArray[i++] = element;
        }
        return resultArray;
    }
}
