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

class RangeSumOfBST {

  // int sum = 0;

  // public int rangeSumBST(TreeNode root, int low, int high) {
  // if(root == null) return sum;

  // traverse(root, low, high);
  // return sum;
  // }

  // public void traverse(TreeNode root, int low, int high) {
  // if(root == null) return;

  // traverse(root.left, low, high);
  // if(root.val >= low && root.val <= high) {
  // sum += root.val;
  // }
  // traverse(root.right, low, high);
  // }

  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null)
      return 0;

    int sum = 0;

    if (root.val > low) {
      sum += rangeSumBST(root.left, low, high);
    }

    if (root.val >= low && root.val <= high) {
      sum += root.val;
    }

    if (root.val < high) {
      sum += rangeSumBST(root.right, low, high);
    }

    return sum;
  }
}