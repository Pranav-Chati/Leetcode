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

    // Zigzag Traversal
    public static void testZigzagTraversal() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = TreeBreadthFirstSearch.zigzagTraversal(root);
        System.out.println("Zigzag traversal: " + result);
    }

    // Reverse Level Order Traversal
    public static void testReverseTraverseBinaryTree() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = TreeBreadthFirstSearch.reverseTraverseBinaryTree(root);
        System.out.println("Reverse level order traversal: " + result);
    }

    // Level Averages in a Binary Tree
    public static void testFindLevelAverages() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = TreeBreadthFirstSearch.findLevelAverages(root);
        System.out.print("Level averages are:" + result);
    }

    // Minimum Depth of a Binary Tree
    public static void testMinDepthOfBinaryTree() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + TreeBreadthFirstSearch.minDepthOfBinaryTree(root) + "\t 2");
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + TreeBreadthFirstSearch.minDepthOfBinaryTree(root) + "\t 3");
    }

    // Level Order Successor
    public static void testFindLevelOrderSuccessor() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = TreeBreadthFirstSearch.findLevelOrderSuccessor(root, 12);
        if (result != null)
            System.out.println("findLevelOrderSuccessor: " + result.val + "\t 7");

        result = TreeBreadthFirstSearch.findLevelOrderSuccessor(root, 9);
        if (result != null)
            System.out.println("findLevelOrderSuccessor: " + result.val + "\t 10");
        else
            System.out.println("findLevelOrderSuccessor: null \t null");
    }

    public static void main(String[] args) {
        // Binary Tree Level Order Traversal
        testTraverseBinaryTree();

        // Reverse Level Order Traversal
        testReverseTraverseBinaryTree();
        System.out.println();

        // Zigzag Traversal
        testZigzagTraversal();
        System.out.println();

        // Level Averages in a Binary Tree
        testFindLevelAverages();
        System.out.println();

        // Minimum Depth of a Binary Tree
        testMinDepthOfBinaryTree();
        System.out.println();

        // Level Order Successor
        testFindLevelOrderSuccessor();
        System.out.println();
    }
}
