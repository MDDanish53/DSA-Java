import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class SerializeAndDeserializeBT {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null)
      return "";

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (sb.length() > 0) {
        sb.append(',');
      }
      if (node == null) {
        sb.append('n');
      } else {
        sb.append(node.val);
        queue.offer(node.left);
        queue.offer(node.right);
      }
    }

    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty())
      return null;

    String[] parts = data.split(",");
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
    queue.offer(root);

    int i = 1;
    while (i < parts.length && !queue.isEmpty()) {
      TreeNode parent = queue.poll();

      // left child
      if (i < parts.length && !parts[i].equals("n")) {
        TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
        parent.left = left;
        queue.offer(left);
      }
      i++;

      // right child
      if (i < parts.length && !parts[i].equals("n")) {
        TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
        parent.right = right;
        queue.offer(right);
      }
      i++;
    }

    return root;
  }
}
