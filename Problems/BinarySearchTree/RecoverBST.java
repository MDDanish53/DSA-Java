
// Definition for a binary tree node.
class TreeNode {
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

class Solution {

  private TreeNode prev;
  private TreeNode first;
  private TreeNode middle;
  private TreeNode last;

  public void inorder(TreeNode root) {
    if (root == null)
      return;

    inorder(root.left);

    if (prev != null && (root.val < prev.val)) {
      // if this is first violation, mark these two nodes as first and middle
      if (first == null) {
        first = prev;
        middle = root;
      } else {
        // if this is second violation, mark this node as last
        last = root;
      }
    }
    // mark this node as previous
    prev = root;
    inorder(root.right);
  }

  public void recoverTree(TreeNode root) {
    first = middle = last = null;
    prev = new TreeNode(Integer.MIN_VALUE);
    inorder(root);
    if (first != null && last != null) {
      int t = first.val;
      first.val = last.val;
      last.val = t;
    } else if (first != null && middle != null) {
      int t = first.val;
      first.val = middle.val;
      middle.val = t;
    }
  }
}