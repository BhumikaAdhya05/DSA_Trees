// LeetCode 199: Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/

// ✅ BFS: Level Order - take last node per level
// Time Complexity: O(n)
// Space Complexity: O(n)

class BinaryTreeRightSideView {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode last = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                last = node;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (last != null) view.add(last.val);
        }

        return view;
    }

    // ✅ DFS (right-first preorder)
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        dfs(root, 0, view);
        return view;
    }

    private void dfs(TreeNode node, int depth, List<Integer> view) {
        if (node == null) return;
        if (depth == view.size()) view.add(node.val);

        dfs(node.right, depth + 1, view);
        dfs(node.left, depth + 1, view);
    }
}
