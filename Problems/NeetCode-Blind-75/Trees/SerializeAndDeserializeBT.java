// Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class SerializeAndDeserializeBT {

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
    if (data == null || data.length() == 0)
      return null;

    String[] nums = data.split(",");

    TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;
    while (!queue.isEmpty() && i < nums.length) {

      TreeNode parent = queue.poll();

      if (i < nums.length && !nums[i].equals("n")) {
        TreeNode left = new TreeNode(Integer.parseInt(nums[i]));
        parent.left = left;
        queue.offer(left);
      }
      i++;

      if (i < nums.length && !nums[i].equals("n")) {
        TreeNode right = new TreeNode(Integer.parseInt(nums[i]));
        parent.right = right;
        queue.offer(right);
      }
      i++;
    }

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));