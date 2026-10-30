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

class Solution1 {

  public int maxPathSum(TreeNode root) {
    int[] maxValue = new int[1];
    maxValue[0] = Integer.MIN_VALUE;
    findMaxSum(root, maxValue);
    return maxValue[0];
  }

  public int findMaxSum(TreeNode root, int maxValue[]) {
    if (root == null) {
      return 0;
    }

    int leftSum = Math.max(0, findMaxSum(root.left, maxValue));
    int rightSum = Math.max(0, findMaxSum(root.right, maxValue));

    maxValue[0] = Math.max(maxValue[0], leftSum + root.val + rightSum);

    return root.val + Math.max(leftSum, rightSum);
  }
}

class Solution2 {

  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    findMax(root);
    return max;
  }

  public int findMax(TreeNode root) {
    if (root == null)
      return 0;

    int left = Math.max(0, findMax(root.left));
    int right = Math.max(0, findMax(root.right));

    max = Math.max(max, left + root.val + right);

    return root.val + Math.max(left, right);
  }

}