// LeetCode 98: Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree/

// ✅ Optimal DFS with min/max bounds
// Time Complexity: O(n)
// Space Complexity: O(h)

class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ✅ Optimal DFS with value bounds
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValid(node.left, min, node.val) &&
               isValid(node.right, node.val, max);
    }

    // 🔁 Brute Force: Inorder traversal must be strictly increasing
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isValidBSTInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) return false;
        }
        return true;
    }

    private void inorderTraversal(TreeNode node, List<Integer> inorder) {
        if (node == null) return;
        inorderTraversal(node.left, inorder);
        inorder.add(node.val);
        inorderTraversal(node.right, inorder);
    }
}
