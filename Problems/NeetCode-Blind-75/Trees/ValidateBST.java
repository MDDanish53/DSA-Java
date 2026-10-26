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

class ValidateBST {
  public boolean isValidBST(TreeNode root) {
    List<Integer> values = new ArrayList<>();

    helper(root, values);
    int prev = values.get(0);
    for (int i = 1; i < values.size(); i++) {
      if (values.get(i) <= prev) {
        return false;
      }
      prev = values.get(i);
    }
    return true;
  }

  public void helper(TreeNode root, List<Integer> values) {
    if (root == null) {
      return;
    }

    helper(root.left, values);
    values.add(root.val);
    helper(root.right, values);
  }
}