package tests;

import java.util.List;

import helper.TreeNode;
import leetcode.TreeBreadthFirstSearch;

public class TestTreeBreadthFirstSearch {
    // Binary Tree Level Order Traversal
    public static void testTraverseBinaryTree() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = TreeBreadthFirstSearch.traverseBinaryTree(root);
        System.out.println("traverseBinaryTree");
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        // Binary Tree Level Order Traversal
        testTraverseBinaryTree();
    }
}
