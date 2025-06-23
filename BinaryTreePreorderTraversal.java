// LeetCode 144: Binary Tree Preorder Traversal
// https://leetcode.com/problems/binary-tree-preorder-traversal/

// ✅ Optimal Iterative using Stack
// Time Complexity: O(n)
// Space Complexity: O(h)

class BinaryTreePreorderTraversal {

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

    // ✅ Recursive DFS
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderDFS(root, result);
        return result;
    }

    private void preorderDFS(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorderDFS(node.left, result);
        preorderDFS(node.right, result);
    }

    // 🔁 Iterative Using Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> preorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }

        return result;
    }
}
