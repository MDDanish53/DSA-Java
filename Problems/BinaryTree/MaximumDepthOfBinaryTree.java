
import java.util.LinkedList;
import java.util.Queue;

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

class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    Queue<TreeNode> elementQueue = new LinkedList<>();
    elementQueue.add(root);
    int numberOfLevels = -1;

    while (true) {

      // Maintain a count of nodes at each level
      int nodeCountAtLevel = elementQueue.size();
      if (nodeCountAtLevel == 0) {
        // if we find no nodes at level, it means tree has ended, so return
        return numberOfLevels + 1;
      }

      // Dequeue all the nodes present at a particular level and add its childs to the
      // queue
      while (nodeCountAtLevel > 0) {
        TreeNode element = elementQueue.poll();
        if (element.left != null)
          elementQueue.add(element.left);
        if (element.right != null)
          elementQueue.add(element.right);
        nodeCountAtLevel--;
      }

      numberOfLevels++;
    }
  }
}