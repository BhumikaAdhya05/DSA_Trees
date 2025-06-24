// LeetCode 297: Serialize and Deserialize Binary Tree
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// ✅ BFS or DFS Encoding
// Time Complexity: O(n)
// Space Complexity: O(n)

class SerializeDeserializeBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ✅ BFS Encoding
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "null";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node == null) {
                    sb.append("null,");
                } else {
                    sb.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("null")) return null;

            String[] nodes = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;

            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();

                if (!nodes[i].equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(current.left);
                }
                i++;

                if (!nodes[i].equals("null")) {
                    current.right = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(current.right);
                }
                i++;
            }

            return root;
        }
    }

    // ❌ Brute Force: DFS with full pre + in order — only works for unique nodes
}