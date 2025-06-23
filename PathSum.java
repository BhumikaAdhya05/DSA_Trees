// LeetCode 112: Path Sum
// https://leetcode.com/problems/path-sum/

// ✅ Recursive DFS to check root-to-leaf sum
// Time Complexity: O(n)
// Space Complexity: O(h)

class PathSum {

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

    // ✅ Optimal Recursive DFS
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null)
            return root.val == targetSum;

        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    // 🔁 Brute Force: BFS traversal with cumulative sums
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int currSum = sumQueue.poll();

            if (node.left == null && node.right == null && currSum == targetSum) {
                return true;
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(currSum + node.left.val);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(currSum + node.right.val);
            }
        }

        return false;
    }
}
