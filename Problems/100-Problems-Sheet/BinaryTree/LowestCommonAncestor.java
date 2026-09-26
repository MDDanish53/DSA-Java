// Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.equals(p) || root.equals(q)) {
      return root;
    }

    TreeNode lans = lowestCommonAncestor(root.left, p, q);
    TreeNode rans = lowestCommonAncestor(root.right, p, q);

    if (lans == null) {
      return rans;
    } else if (rans == null) {
      return lans;
    }
    return root;
  }
}