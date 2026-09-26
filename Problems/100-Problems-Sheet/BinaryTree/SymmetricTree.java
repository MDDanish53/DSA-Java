
// Definition for a binary tree node.

import java.util.LinkedList;
import java.util.Queue;

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

class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;

    Queue<TreeNode> leftTree = new LinkedList<>();
    Queue<TreeNode> rightTree = new LinkedList<>();

    leftTree.add(root.left);
    rightTree.add(root.right);

    while (!leftTree.isEmpty() && !rightTree.isEmpty()) {

      TreeNode leftNode = leftTree.poll();
      TreeNode rightNode = rightTree.poll();

      if (leftNode == null && rightNode == null)
        continue;

      if (leftNode == null || rightNode == null)
        return false;

      if (leftNode.val != rightNode.val)
        return false;

      // add left tree child in left-to-right order
      leftTree.add(leftNode.left);
      leftTree.add(leftNode.right);

      // add right tree child in right-to-left order
      rightTree.add(rightNode.right);
      rightTree.add(rightNode.left);
    }

    return true;
  }
}