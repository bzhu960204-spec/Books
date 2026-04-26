package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {
    /*

    Given an integer array nums, return all the triplets

    [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.

    * */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if ((nums[l] + nums[r]) == -nums[i]) {
                    ArrayList<Integer> combination = new ArrayList<>();
                    combination.add(nums[i]);
                    combination.add(nums[l]);
                    combination.add(nums[r]);
                    resultList.add(combination);
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                } else if ((nums[l] + nums[r]) > -nums[i]) {
                    r--;
                } else if ((nums[l] + nums[r]) < -nums[i]) {
                    l++;
                }
            }
        }
        return resultList;
    }
}
