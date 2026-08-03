import java.util.Stack;

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

class BSTIterator {

  Stack<TreeNode> stack = new Stack<>();

  // store all the left nodes from curr node
  public void storeLeftNodes(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  public BSTIterator(TreeNode root) {
    // store all the left nodes from root
    storeLeftNodes(root);
  }

  public int next() {
    // pop the top nodes i.e. the smallest node
    TreeNode curr = stack.pop();
    // if the smallest node has right node then store all the left nodes from the
    // right node
    if (curr.right != null) {
      storeLeftNodes(curr.right);
    }
    // return the popped value
    return curr.val;
  }

  public boolean hasNext() {
    // if stack is not empty means bst has next node (from curr node)
    return !stack.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */