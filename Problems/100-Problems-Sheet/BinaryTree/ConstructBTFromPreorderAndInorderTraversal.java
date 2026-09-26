// Definition for a binary tree node.

import java.util.HashMap;
import java.util.Map;

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

public class ConstructBTFromPreorderAndInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {

    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    // add the values of inorder[] as [value, index]
    for (int i = 0; i < inorder.length; i++) {
      inOrderIndexMap.put(inorder[i], i);
    }

    return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length - 1);
  }

  public TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left, int right) {

    TreeNode root = new TreeNode(preorder[rootIndex]); // root of tree is at preorder[0]

    // create left and right subtree
    // the root is between the left subtree and right subtree in inorder[], here we
    // get the idx of root in inorder[]
    int mid = inOrderIndexMap.get(preorder[rootIndex]);
    // mid = 1
    if (mid > left) {
      root.left = splitTree(preorder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
    }
    if (mid < right) {
      root.right = splitTree(preorder, inOrderIndexMap, rootIndex + mid - left + 1, mid + 1, right);
    }
    return root;
  }
}
