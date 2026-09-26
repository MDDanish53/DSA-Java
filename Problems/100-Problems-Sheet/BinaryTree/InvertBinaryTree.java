
import java.util.LinkedList;
import java.util.Queue;


// Definition for a binary tree node.
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class InvertBinaryTree {
  // my written solution
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    invert(root);
    return root;
  }

  public void invert(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invert(root.left);
    invert(root.right);
  }

  // youtube solution
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
  }

  // iterative approach using level order traversal
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;

      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
    return root;
  }
}