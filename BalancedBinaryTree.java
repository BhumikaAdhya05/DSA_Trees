// LeetCode Problem 110: Balanced Binary Tree
// https://leetcode.com/problems/balanced-binary-tree/

// ✅ Optimal Approach: Bottom-up DFS
// Time Complexity: O(n)
// Space Complexity: O(h)

class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ✅ Optimal Bottom-up DFS
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        int right = checkHeight(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    // 🔁 Brute Force: Top-down recursion (recomputes height repeatedly)
    // Time Complexity: O(n^2)
    // Space Complexity: O(h)
    public boolean isBalancedBrute(TreeNode root) {
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) return false;

        return isBalancedBrute(root.left) && isBalancedBrute(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
