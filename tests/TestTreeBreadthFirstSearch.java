package tests;

import java.util.List;

import helper.TreeNode;
import helper.TreeNode1;
import leetcode.TreeBreadthFirstSearch;

public class TestTreeBreadthFirstSearch {
    public static void printLevelorder(TreeNode1 root) {
        TreeNode1 nextLevelRoot = root;
        while (nextLevelRoot != null) {
            TreeNode1 current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.println(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void printTree(TreeNode1 root) {
        while (root.next != null) {
            System.out.print(root.val + " ");
            root = root.next;

        }
        System.out.println("null");
    }

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

    // Connect Level Order Siblings
    public static void testConnectLevelOrderSiblings() {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        TreeBreadthFirstSearch.connectLevelOrderSiblings(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        printLevelorder(root);
    }

    // Connect All Level Order Siblings
    public static void testConnectAllLevelOrderSiblings() {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        TreeBreadthFirstSearch.connectAllLevelOrderSiblings(root);
        printTree(root);
    }

    // Right View of a Binary Tree
    public static void testRightViewOfBinaryTree() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = TreeBreadthFirstSearch.rightViewOfBinaryTree(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
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

        // Connect Level Order Siblings
        System.out.println("Connect Level Order Siblings");
        testConnectLevelOrderSiblings();
        System.out.println();

        // Connect All Level Order Siblings
        System.out.println("Connect All Level Order Siblings");
        testConnectAllLevelOrderSiblings();
        System.out.println();

        // Right View of a Binary Tree
        System.out.println("Right View of a Binary Tree");
        testRightViewOfBinaryTree();
        System.out.println();
    }
}
