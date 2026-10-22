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

class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(p);
    queue.add(q);

    while (!queue.isEmpty()) {
      TreeNode first = queue.poll();
      TreeNode second = queue.poll();

      if (first == null && second == null) {
        continue;
      } else if (first == null || second == null || first.val != second.val) {
        return false;
      }

      queue.add(first.left);
      queue.add(second.left);
      queue.add(first.right);
      queue.add(second.right);
    }
    return true;
  }
}