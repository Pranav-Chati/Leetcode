package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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

        current.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<Integer>(current));
        } else {
            allPathRecursive(root.left, sum - root.val, allPaths, current);
            allPathRecursive(root.right, sum - root.val, allPaths, current);
        }

        current.remove(current.size() - 1);
    }

    /*
     * Problem: Sum of Path Numbers
     * Given a binary tree where each node can only have a digit (0-9) value, each
     * root-to-leaf path will represent a number. Find the total sum of all the
     * numbers represented by all paths.
     */
    public static int sumOfPathNumbers(TreeNode root) {
        int numbers = 0;
        int sum = 0;
        return sumOfPathNumbersRecursive(root, numbers, sum);
    }

    public static int sumOfPathNumbersRecursive(TreeNode currentNode, int number, int sum) {
        if (currentNode == null)
            return 0;

        number = 10 * number + currentNode.val;
        if (currentNode.left == null && currentNode.right == null)
            return number;

        return sumOfPathNumbersRecursive(currentNode.left, number, sum)
                + sumOfPathNumbersRecursive(currentNode.right, number, sum);

    }

    /*
     * problem: Path With Given Sequence
     * Given a binary tree and a number sequence, find if the sequence is present as
     * a root-to-leaf path in the given tree.
     */
    public static boolean pathWithGivenSequence(TreeNode root, int[] sequence) {
        return pathWithGivenSequenceRecursive(root, sequence, 0);
    }

    public static boolean pathWithGivenSequenceRecursive(TreeNode root, int[] sequence, int index) {
        if (root == null)
            return false;

        if (index >= sequence.length || root.val != sequence[index])
            return false;

        if (root.left == null && root.right == null && index == sequence.length - 1)
            return true;

        return pathWithGivenSequenceRecursive(root.left, sequence, index + 1)
                || pathWithGivenSequenceRecursive(root.right, sequence, index + 1);
    }

    /*
     * problem: Count Paths for a Sum
     * Given a binary tree and a number ‘S’, find all paths in the tree such that
     * the sum of all the node values of each path equals ‘S’. Please note that the
     * paths can start or end at any node but all paths must follow direction from
     * parent to child (top to bottom).
     */
    public static int countPathsForSum(TreeNode root, int S) {
        // List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        // countPathForSumRecursive(root, S, allPaths, currentPath);
        return countPathForSumRecursive2(root, S, currentPath);

        // return allPaths.size();
    }

    public static void countPathForSumRecursive(TreeNode current, int sum, List<List<Integer>> allPaths,
            List<Integer> currentPath) {
        if (current == null)
            return;

        currentPath.add(current.val);
        if (current.val == sum) { // no longer has to be a leaf
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            countPathForSumRecursive(current.left, sum, allPaths, new ArrayList<>());
            countPathForSumRecursive(current.right, sum, allPaths, new ArrayList<>());
            countPathForSumRecursive(current.left, sum - current.val, allPaths, currentPath);
            countPathForSumRecursive(current.right, sum - current.val, allPaths, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static int countPathForSumRecursive2(TreeNode current, int sum, List<Integer> currentPath) {
        if (current == null)
            return 0;

        currentPath.add(current.val);
        int pathCount = 0;
        int pathSum = 0;
        ListIterator<Integer> previousNodes = currentPath.listIterator(currentPath.size());
        while (previousNodes.hasPrevious()) {
            pathSum += previousNodes.previous();
            if (pathSum == sum) {
                pathCount++;
            }
        }

        pathCount += countPathForSumRecursive2(current.left, sum, currentPath);
        pathCount += countPathForSumRecursive2(current.right, sum, currentPath);

        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }

    /*
     * problem: Tree Diameter
     * Given a binary tree, find the length of its diameter. The diameter of a tree
     * is the number of nodes on the longest path between any two leaf nodes. The
     * diameter of a tree may or may not pass through the root.
     * 
     * Note: You can always assume that there are at least two leaf nodes in the
     * given tree.
     */
    public static int maxDiameter = 0;

    public static int findDiameter(TreeNode root) {
        findDiameterRecursive(root);
        return maxDiameter;
    }

    // this just finds the total number of nodes
    public static int findDiameterRecursive(TreeNode root) {
        if (root == null)
            return 0;

        int leftDiameter = findDiameterRecursive(root.left);
        int rightDiameter = findDiameterRecursive(root.right);

        int diameter = leftDiameter + rightDiameter + 1;
        maxDiameter = Math.max(maxDiameter, diameter);

        return Math.max(leftDiameter, rightDiameter) + 1;
    }

    /*
     * problem: Path with Maximum Sum
     * Find the path with the maximum sum in a given binary tree. Write a function
     * that returns the maximum sum. A path can be defined as a sequence of nodes
     * between any two nodes and doesn’t necessarily pass through the root.
     */
    public static int maxSum = Integer.MIN_VALUE;

    public static int pathWithMaxSum(TreeNode root) {
        pathWithMaxSumRecursive(root);
        return maxSum;
    }

    public static int pathWithMaxSumRecursive(TreeNode currentNode) {
        if (currentNode == null)
            return 0;

        int leftSum = Math.max(pathWithMaxSumRecursive(currentNode.left), 0);
        int rightSum = Math.max(pathWithMaxSumRecursive(currentNode.right), 0);

        int sum = leftSum + rightSum + currentNode.val;

        maxSum = Math.max(maxSum, sum);

        return Math.max(leftSum, rightSum) + currentNode.val;
    }
}
