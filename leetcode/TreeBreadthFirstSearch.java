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
}
