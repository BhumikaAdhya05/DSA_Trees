// LeetCode 114: Flatten Binary Tree to Linked List
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// ✅ Optimal Reverse Postorder Traversal
// Time Complexity: O(n)
// Space Complexity: O(h)

class FlattenBinaryTreeToLinkedList {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private TreeNode prev = null;

    // ✅ Reverse Postorder (right -> left -> root)
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    // 🔁 Iterative using Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public void flattenIterative(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);

            if (!stack.isEmpty()) curr.right = stack.peek();
            curr.left = null;
        }
    }

    // ❌ Brute Force: Store preorder in list and rebuild tree → O(n) space
}
