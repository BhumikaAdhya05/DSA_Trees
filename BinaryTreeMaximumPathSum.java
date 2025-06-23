// LeetCode 124: Binary Tree Maximum Path Sum
// https://leetcode.com/problems/binary-tree-maximum-path-sum/

// ✅ Optimal: DFS + track global max
// Time Complexity: O(n)
// Space Complexity: O(h)

class BinaryTreeMaximumPathSum {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(maxGain(node.left), 0); // ignore negatives
        int right = Math.max(maxGain(node.right), 0);

        maxSum = Math.max(maxSum, node.val + left + right);

        return node.val + Math.max(left, right); // return max gain to parent
    }

    // ❌ Brute Force: Try all paths - exponential & redundant
}
