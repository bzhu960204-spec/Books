package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * 非最佳
 */
public class Q98 {
    /*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left
    subtree
     of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    */
    List<Integer> treeNodeValueList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        InOrderIterate(root);
        for (int i = 1; i < treeNodeValueList.size(); i++) {
            if (treeNodeValueList.get(i) <= treeNodeValueList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    void InOrderIterate(TreeNode node) {
        if (node != null) {
            InOrderIterate(node.left);
            treeNodeValueList.add(node.val);
//            System.out.println(node.val);
            InOrderIterate(node.right);
        }
    }
}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}