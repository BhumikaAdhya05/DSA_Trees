// LeetCode 145: Binary Tree Postorder Traversal
// https://leetcode.com/problems/binary-tree-postorder-traversal/

// ✅ Optimal Iterative (2 stacks)
// Time Complexity: O(n)
// Space Complexity: O(n)

class BinaryTreePostorderTraversal {

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

    // ✅ Recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderDFS(root, result);
        return result;
    }

    private void postorderDFS(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderDFS(node.left, result);
        postorderDFS(node.right, result);
        result.add(node.val);
    }

    // 🔁 Iterative Using 2 Stacks
    public List<Integer> postorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}
