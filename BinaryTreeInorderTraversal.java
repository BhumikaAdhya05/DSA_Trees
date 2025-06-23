// LeetCode 94: Binary Tree Inorder Traversal
// https://leetcode.com/problems/binary-tree-inorder-traversal/

// ✅ Iterative and Recursive solutions
// Time Complexity: O(n)
// Space Complexity: O(h)

class BinaryTreeInorderTraversal {

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderDFS(root, result);
        return result;
    }

    private void inorderDFS(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderDFS(node.left, result);
        result.add(node.val);
        inorderDFS(node.right, result);
    }

    // 🔁 Iterative Using Stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }
}
