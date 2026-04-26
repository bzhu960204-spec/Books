package LeetCode.TopInterviewQuestions;

public class Q102 {
    /*

 Given the root of a binary tree, return its maximum depth.

 A binary tree's maximum depth is the number of nodes along the longest path
 from the root node down to the farthest leaf node.

    * */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null & root.right == null) return 1;
        if (root.left == null) return 1 + maxDepth(root.right);
        if (root.right == null) return 1 + maxDepth(root.left);
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
