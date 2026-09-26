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

class KthSmallestInBST {
  // solution using inorder traversal
  // public int kthSmallest(TreeNode root, int k) {
  // List<Integer> inOrderTraversal = new ArrayList<>();
  // traverse(root, inOrderTraversal);
  // return inOrderTraversal.get(k-1);
  // }

  // public void traverse(TreeNode root, List<Integer> inOrderTraversal) {
  // if(root == null) {
  // return;
  // }
  // traverse(root.left, inOrderTraversal);
  // inOrderTraversal.add(root.val);
  // traverse(root.right, inOrderTraversal);
  // }

  // optimized solution
  int prevOrder = 0;

  public int kthSmallest(TreeNode root, int k) {
    if (root == null) {
      return -1;
    }

    if (root.left != null) {
      int leftAns = kthSmallest(root.left, k);
      if (leftAns != -1) {
        return leftAns;
      }
    }

    if (prevOrder + 1 == k) {
      return root.val;
    }
    prevOrder++;

    if (root.right != null) {
      int rightAns = kthSmallest(root.right, k);
      if (rightAns != -1) {
        return rightAns;
      }
    }

    return -1;
  }
}