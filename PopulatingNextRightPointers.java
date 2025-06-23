// LeetCode 116: Populating Next Right Pointers in Each Node
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// ✅ Level Order Traversal (BFS)
// Time Complexity: O(n)
// Space Complexity: O(n)

class PopulatingNextRightPointers {

    public class Node {
        public int val;
        public Node left, right, next;
        public Node(int val) { this.val = val; }
    }

    // ✅ BFS
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (prev != null) prev.next = node;
                prev = node;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return root;
    }

    // ✅ Optimal Constant Space (Perfect Binary Tree Only)
    public Node connectOptimal(Node root) {
        if (root == null) return null;

        Node levelStart = root;

        while (levelStart.left != null) {
            Node curr = levelStart;

            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null)
                    curr.right.next = curr.next.left;

                curr = curr.next;
            }

            levelStart = levelStart.left;
        }

        return root;
    }
}
