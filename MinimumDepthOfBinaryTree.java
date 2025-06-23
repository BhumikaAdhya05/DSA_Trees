// LeetCode 111: Minimum Depth of Binary Tree
// https://leetcode.com/problems/minimum-depth-of-binary-tree/

// ✅ Optimal DFS (recursive)
// Time Complexity: O(n)
// Space Complexity: O(h)

class MinimumDepthOfBinaryTree {

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

    // ✅ Optimal DFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // 🔁 Brute Force: BFS (first null child hit gives answer)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) return depth;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            depth++;
        }

        return depth;
    }
}
