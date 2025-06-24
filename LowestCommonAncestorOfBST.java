// LeetCode 235: Lowest Common Ancestor of a BST
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

// ✅ Optimal: Exploit BST properties
// Time Complexity: O(h)
// Space Complexity: O(1) iterative, O(h) recursive

class LowestCommonAncestorOfBST {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ✅ Recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    // 🔁 Iterative
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}