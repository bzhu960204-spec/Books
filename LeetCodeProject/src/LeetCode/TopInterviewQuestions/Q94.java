package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q94 {

    /*
    Given the root of a binary tree, return the inorder traversal of its nodes' values.
    */
    List<Integer> inOrderArray = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrderTraverse(root);
        return inOrderArray;
    }

    void inOrderTraverse(TreeNode node) {
        if (node != null) {
            inOrderTraverse(node.left);
            inOrderArray.add(node.val);
            inOrderTraverse(node.right);
        }
    }

    public static void main(String[] args) {

    }
}


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}