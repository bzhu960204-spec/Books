package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q78 {
    /*
    Given an integer array nums of unique elements, return all possible
    subsets
     (the power set).

    The solution set must not contain duplicate subsets. Return the solution in any order.
    */

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 1) {
            return new ArrayList<>() {{
                add(new ArrayList<>());
                add(new ArrayList<>() {{
                    add(nums[0]);
                }});
            }};
        }
        int[] nums2 = new int[nums.length - 1];
        System.arraycopy(nums, 0, nums2, 0, nums2.length);
        List<List<Integer>> resultList = new ArrayList<>();
        for (List<Integer> list : subsets(nums2)) {
            resultList.add(list);

            List<Integer> newResult = new ArrayList<>(list);
            newResult.add(nums[nums.length - 1]);

            resultList.add(newResult);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        Q78 q78 = new Q78();
        System.out.println(q78.subsets(array));
    }
}
