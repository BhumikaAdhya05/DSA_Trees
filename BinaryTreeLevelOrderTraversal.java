// LeetCode 102: Binary Tree Level Order Traversal
// https://leetcode.com/problems/binary-tree-level-order-traversal/

// ✅ Level Order using BFS
// Time Complexity: O(n)
// Space Complexity: O(n)

class BinaryTreeLevelOrderTraversal {

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

    // ✅ BFS using Queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }

    // 🔁 Brute Force (DFS with depth tracking)
    // Time Complexity: O(n)
    // Space Complexity: O(h + n)
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelDFS(root, 0, result);
        return result;
    }

    private void levelDFS(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) return;
        if (depth == result.size()) result.add(new ArrayList<>());
        result.get(depth).add(node.val);
        levelDFS(node.left, depth + 1, result);
        levelDFS(node.right, depth + 1, result);
    }
}
