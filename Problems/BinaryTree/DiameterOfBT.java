
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

class DiameterOfBT {
  int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    longestPath(root);
    return diameter;
  }

  private int longestPath(TreeNode root) {
    if (root == null) {
      return 0;
    } 
    int leftLongestPath = longestPath(root.left);
    int rightLongestPath = longestPath(root.right);
    diameter = Math.max(leftLongestPath + rightLongestPath, diameter);
    return Math.max(leftLongestPath, rightLongestPath) + 1;
  }
}