package leetcode;

import helper.TreeNode;

public class TreeDepthFirstSearch {
    /*
     * problem: Binary Tree Path Sum
     * Given a binary tree and a number ‘S’, find if the tree has a path from
     * root-to-leaf such that the sum of all the node values of that path equals
     * ‘S’.
     */
    public static boolean binaryTreePathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return binaryTreePathSum(root.left, sum - root.val) || binaryTreePathSum(root.right, sum - root.val);

    }
}
