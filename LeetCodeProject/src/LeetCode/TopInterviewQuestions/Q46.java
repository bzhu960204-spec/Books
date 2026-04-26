package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Q46 {
    /*

    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

    */

    public static List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> originalList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrackResult(originalList,new ArrayList<>());
        return result;
    }

    public void backtrackResult(List<Integer> addedIntegers, List<Integer> resultPermutation) {
        if (addedIntegers.size() == 0) {
            result.add(resultPermutation);
        }
        List<Integer> addedIntegerParameter = new ArrayList<>(addedIntegers);
        for (Integer i : addedIntegers) {
            resultPermutation.add(i);
            addedIntegerParameter.remove(i);
            backtrackResult(addedIntegerParameter, new ArrayList<>(resultPermutation));
            resultPermutation.remove(i);
            addedIntegerParameter.add(i);
        }
    }

    public static void main(String[] args) {
        Q46 q46 = new Q46();
//        q46.backtrackResult(Arrays.asList(0,1), new ArrayList<>());
        System.out.println(q46.permute(new int[]{0,1}));
    }
}
