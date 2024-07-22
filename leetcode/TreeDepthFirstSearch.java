package leetcode;
public class TreeDepthFirstSearch {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * problem: Binary Tree Path Sum
     * Given a binary tree and a number ‘S’, find if the tree has a path from
     * root-to-leaf such that the sum of all the node values of that path equals
     * ‘S’.
     */
    public static boolean binaryTreePathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return binaryTreePathSum(root.left, sum - root.val) || binaryTreePathSum(root.right, sum - root.val);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path: " + binaryTreePathSum(root, 23));
        System.out.println("Tree has path: " + binaryTreePathSum(root, 16));
    }
}
