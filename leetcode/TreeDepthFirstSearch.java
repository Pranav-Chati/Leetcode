package leetcode;

import java.util.ArrayList;
import java.util.List;

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
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        return binaryTreePathSum(root.left, sum - root.val) || binaryTreePathSum(root.right, sum - root.val);
    }

    /*
     * problem: All Paths for a Sum
     * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such
     * that the sum of all the node values of each path equals ‘S’.
     */
    public static int allPathsSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        allPathRecursive(root, sum, allPaths, currentPath);
        return allPaths.size();
    }

    public static void allPathRecursive(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> current) {
        if (root == null)
            return;

        if (root.val == sum && root.left == null && root.right == null) {
            allPaths.add(current);
        } else {
            allPathRecursive(root.left, sum - root.val, allPaths, current);
            allPathRecursive(root.right, sum - root.val, allPaths, current);
        }

        current.remove(current.size() - 1);
        return;
    }
}
