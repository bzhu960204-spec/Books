package LeetCode.TopInterviewQuestions;

import jdk.jshell.EvalException;

import java.util.HashMap;
import java.util.Map;

// 非最优解
public class Q105 {

    /*
    Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
    and inorder is the inorder traversal of the same tree, construct and return the binary tree.
    */
    Map<Integer, Integer> valueIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueIndex.put(inorder[i], i);
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode childNode = new TreeNode(preorder[i]);
            addNode(treeNode, childNode);
        }
        return treeNode;
    }

    void addNode(TreeNode root, TreeNode node) {
        if (valueIndex.get(node.val) > valueIndex.get(root.val)) {
            if (root.right == null) {
                root.right = node;
            } else {
                addNode(root.right, node);
            }
        } else {
            if (root.left == null) {
                root.left = node;
            } else {
                addNode(root.left, node);
            }
        }
    }
}
