// LeetCode Problem 100: Same Tree
// https://leetcode.com/problems/same-tree/

// ✅ Optimal Approach: Recursive DFS
// Time Complexity: O(n)
// Space Complexity: O(h) - Call stack (h = height of tree)

class SameTree {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ✅ Optimal Recursive Solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 🔁 Brute Force: BFS level comparison (less common, more complex)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            queue1.offer(node1.left);
            queue1.offer(node1.right);

            queue2.offer(node2.left);
            queue2.offer(node2.right);
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}
