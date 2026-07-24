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

class PathSum {
  int target;

  public boolean hasPathSum(TreeNode root, int targetSum) {
    target = targetSum;
    return helper(root, 0);
  }

  public boolean helper(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    sum += root.val;
    if (root.left == null && root.right == null) {
      return sum == target;
    }
    boolean leftAns = helper(root.left, sum);
    boolean rightAns = helper(root.right, sum);
    return leftAns || rightAns;
  }
}
