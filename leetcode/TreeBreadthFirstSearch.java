package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper.*;

public class TreeBreadthFirstSearch {
    /*
     * problem: Binary Tree Level Order Traversal
     * Given a binary tree, populate an array to represent its level-by-level
     * traversal. You should populate the values of all nodes of each level from
     * left to right in separate sub-arrays.
     */
    public static List<List<Integer>> traverseBinaryTree(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            int levelSize = bfs.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = bfs.poll();
                currentLevel.add(current.val);

                if (current.left != null)
                    bfs.offer(current.left);
                if (current.right != null)
                    bfs.offer(current.right);
            }
            levels.add(currentLevel);
        }

        return levels;

    }

    /*
     * problem: Reverse Level Order Traversal
     * Given a binary tree, populate an array to represent its level-by-level
     * traversal in reverse order, i.e., the lowest level comes first. You should
     * populate the values of all nodes in each level from left to right in separate
     * sub-arrays.
     */
    public static List<List<Integer>> reverseTraverseBinaryTree(TreeNode root) {
        List<List<Integer>> level = new LinkedList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            int sizeOfLevel = bfs.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode current = bfs.poll();
                currentLevel.add(current.val);

                if (current.left != null)
                    bfs.offer(current.left);
                if (current.right != null)
                    bfs.offer(current.right);

            }

            level.add(0, currentLevel);
        }

        return level;
    }

    /*
     * problem: Zigzag Traversal
     * Given a binary tree, populate an array to represent its zigzag level order
     * traversal. You should populate the values of all nodes of the first level
     * from left to right, then right to left for the next level and keep
     * alternating in the same manner for the following levels.
     */
    public static List<List<Integer>> zigzagTraversal(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        boolean rightToLeft = false;

        while (!bfs.isEmpty()) {
            int sizeOfLevel = bfs.size();
            List<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode currentNode = bfs.poll();
                if (rightToLeft)
                    currentLevel.add(0, currentNode.val);
                else
                    currentLevel.add(currentNode.val);
                if (currentNode.left != null)
                    bfs.offer(currentNode.left);
                if (currentNode.right != null)
                    bfs.offer(currentNode.right);
            }

            rightToLeft = !rightToLeft;
            traversal.add(currentLevel);
        }

        return traversal;
    }

    /*
     * problem: Level Averages in a Binary Tree
     * Given a binary tree, populate an array to represent the averages of all of
     * its levels.
     */
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            int currentSize = bfs.size();
            double levelSum = 0;

            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = bfs.poll();
                levelSum += currentNode.val;

                if (currentNode.left != null)
                    bfs.offer(currentNode.left);

                if (currentNode.right != null)
                    bfs.offer(currentNode.right);
            }
            averages.add(levelSum / currentSize);
        }

        return averages;
    }

    /*
     * problem: Minimum Depth of a Binary Tree
     * Find the minimum depth of a binary tree. The minimum depth is the number of
     * nodes along the shortest path from the root node to the nearest leaf node.
     */
    public static int minDepthOfBinaryTree(TreeNode root) {
        int minimumDepth = Integer.MAX_VALUE;
        int currentDepth = 0;

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            int levelSize = bfs.size();
            currentDepth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = bfs.poll();

                if (currentNode.left == null && currentNode.right == null)
                    minimumDepth = Math.min(minimumDepth, currentDepth);

                if (currentNode.left != null)
                    bfs.offer(currentNode.left);
                if (currentNode.right != null)
                    bfs.offer(currentNode.right);
            }
        }

        return minimumDepth;
    }

    /*
     * problem: Level Order Successor
     * Given a binary tree and a node, find the level order successor of the given
     * node in the tree. The level order successor is the node that appears right
     * after the given node in the level order traversal.
     */
    public static TreeNode findLevelOrderSuccessor(TreeNode root, int key) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            TreeNode currentNode = bfs.poll();

            if (currentNode.left != null)
                bfs.offer(currentNode.left);
            if (currentNode.right != null)
                bfs.offer(currentNode.right);

            if (currentNode.val == key)
                break;
        }

        return bfs.peek();
    }
}
