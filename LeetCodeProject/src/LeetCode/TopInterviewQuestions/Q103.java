package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
// 非最优解
public class Q103 {

    /*
    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
    (i.e., from left to right, then right to left for the next level and alternate between).
    */

    List<List<Integer>> resultList = new ArrayList<>();

    List<List<Integer>> reverseResultList = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        InOrderTraverse(root, 0);
        reverseOrderTraverse(root, 0);
        for (int i = 1; i < resultList.size(); i = i + 2) {
            resultList.set(i, reverseResultList.get(i));
        }
        return resultList;
    }

    void InOrderTraverse(TreeNode node, int level) {
        if (node != null) {
            if (resultList.size() < level + 1 || resultList.get(level) == null) {
                resultList.add(level, new ArrayList<>());
            }
            InOrderTraverse(node.left, level + 1);
            resultList.get(level).add(node.val);
            InOrderTraverse(node.right, level + 1);
        }
    }

    void reverseOrderTraverse(TreeNode node, int level) {
        if (node != null) {
            if (reverseResultList.size() < level + 1 || reverseResultList.get(level) == null) {
                reverseResultList.add(level, new ArrayList<>());
            }
            reverseOrderTraverse(node.right, level + 1);
            reverseResultList.get(level).add(node.val);
            reverseOrderTraverse(node.left, level + 1);
        }
    }
}
