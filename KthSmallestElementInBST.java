// LeetCode 230: Kth Smallest Element in a BST
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// ✅ Optimal: Inorder Traversal (BST gives sorted order)
// Time Complexity: O(h + k)
// Space Complexity: O(h)

class KthSmallestElementInBST {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int count = 0, result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }

    // ❌ Brute Force: Store full inorder in array and return kth → O(n)
}
