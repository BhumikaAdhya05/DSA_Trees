// LeetCode 543: Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/

// ✅ DFS + Track max diameter
// Time Complexity: O(n)
// Space Complexity: O(h)

class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    // ❌ Brute Force: Recompute height at each node → O(n^2)
}