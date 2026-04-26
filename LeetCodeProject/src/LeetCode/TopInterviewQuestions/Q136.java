package LeetCode.TopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class Q136 {
    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.
    * */
    public int singleNumber(int[] nums) {
        HashMap map = new HashMap<Integer, String>();
        for (int element : nums) {
            if (map.containsKey(element)) {
                map.remove(element);
            } else {
                map.put(element, "1");
            }
        }
        return (int) map.keySet().toArray()[0];
    }

    public static void main(String[] args) {
        Q136 q136 = new Q136();
        int[] nums = new int[]{1,2,2,3,3};
        System.out.println(q136.singleNumber(nums));
    }
}
