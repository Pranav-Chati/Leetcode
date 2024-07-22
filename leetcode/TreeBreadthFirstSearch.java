package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper.TreeNode;

public class TreeBreadthFirstSearch {

    /*
     * * problem: Binary Tree Level Order Traversa * Given a binary tree, populate
     * an array to represent its level-by-level * traversal. You should populate the
     * values of all nodes of each level from * left to right in separate
     * sub-arrays.
     */
    public static List<List<Integer>> traverseBinaryTree(TreeNode root) {
        List<List<Integer>> sublists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // difference between offer and add could be researching

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // get the current node in the queue + removes it
                currentLevel.add(currentNode.val);

                // this is how we see the children of each level
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            sublists.add(currentLevel);
        }

        return sublists;
    }
}
