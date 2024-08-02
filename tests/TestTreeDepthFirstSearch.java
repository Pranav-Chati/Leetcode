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
        System.out.println("Tree has path: " + TreeDepthFirstSearch.binaryTreePathSum(root, 23) + "\t true");
        System.out.println("Tree has path: " + TreeDepthFirstSearch.binaryTreePathSum(root, 16) + "\t false");
    }

    // All Paths for a Sum
    public static void testAllPathsSum() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Total All Path Sum: " + TreeDepthFirstSearch.allPathsSum(root, 23) + "\t 2");
    }

    // Sum of Path Numbers
    public static void testSumOfPathNumbers() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + TreeDepthFirstSearch.sumOfPathNumbers(root) + "\t 332");
    }

    // Path with Given Sequence
    public static void testPathWithGivenSequence() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println(
                "Tree has path sequence: " + TreeDepthFirstSearch.pathWithGivenSequence(root, new int[] { 1, 0, 7 }));
        System.out.println(
                "Tree has path sequence: " + TreeDepthFirstSearch.pathWithGivenSequence(root, new int[] { 1, 1, 6 }));
    }

    // Count Paths for a Sum
    public static void testCountPathsForSum() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("countPathsForSum: " + TreeDepthFirstSearch.countPathsForSum(root, 11) + "\t 2");

        root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println("countPathsForSum: " + TreeDepthFirstSearch.countPathsForSum(root, 12) + "\t 3");

    }

    // Problem Challenge 1 - Tree Diameter
    public static void testTreeDiameter() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter:" + TreeDepthFirstSearch.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDepthFirstSearch.findDiameter(root));
    }

    // Path With Max Sum
    public static void testPathWithMaxSum() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Maximum Path Sum: " + TreeDepthFirstSearch.pathWithMaxSum(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + TreeDepthFirstSearch.pathWithMaxSum(root));
    }

    public static void main(String[] args) {
        // Binary Tree Path Sum
        testBinaryTreePathSum();
        System.out.println();

        // All Paths for a Sum
        testAllPathsSum();
        System.out.println();

        // Sum of Path Numbers
        testSumOfPathNumbers();
        System.out.println();

        // Path with Given Sequence
        testPathWithGivenSequence();
        System.out.println();

        // Count Paths for a Sum
        testCountPathsForSum();
        System.out.println();

        // Tree Diameter
        testTreeDiameter();
        System.out.println();

        // Path with Maximum Sum
        testPathWithMaxSum();
        System.out.println();
    }
}
