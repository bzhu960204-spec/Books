package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
// 非最优解
public class Q102_2 {
    /*
     Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     */
    List<List<Integer>> resultArray = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        inOrderTraverse(root, 0);
        return resultArray;
    }

    void inOrderTraverse(TreeNode node, int level) {
        if (node != null) {
            if (level >= resultArray.size() || resultArray.get(level) == null) {
                List<Integer> integerList = new ArrayList<>();
                resultArray.add(level, integerList);
            }
            inOrderTraverse(node.left, level + 1);
            resultArray.get(level).add(node.val);
//            inOrderArray.add(node.val);
            inOrderTraverse(node.right, level + 1);
        }
    }

    public static void main(String[] args) {

    }

}
