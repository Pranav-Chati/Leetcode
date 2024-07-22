package tests;

import helper.TreeNode;
import leetcode.TreeDepthFirstSearch;

public class TestTreeDepthFirstSearch {
    // Binary Tree Path Sum
    public static void testBinaryTreePathSum() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("binaryTreePathSum");
        System.out.println("Tree has path: " + TreeDepthFirstSearch.binaryTreePathSum(root, 23));
        System.out.println("Tree has path: " + TreeDepthFirstSearch.binaryTreePathSum(root, 16));
    }

    public static void main(String[] args) {
        // Binary Tree Path Sum
        testBinaryTreePathSum();
        System.out.println();
    }
}
