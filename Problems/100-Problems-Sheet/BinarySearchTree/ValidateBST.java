
import java.util.LinkedList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();
        boolean isValid = true;

        // populate the list in inorder fashion
        helper(root, inOrderList);

        int prev = inOrderList.get(0);
        for(int i = 1; i < inOrderList.size(); i++) {

            // check if curr element (inOrderList.get(i)) is small or equal to previous element (prev), or both are equal
            if(inOrderList.get(i) <= prev) {
                isValid = false;
            }
            prev = inOrderList.get(i);
        }

        return isValid;

    }

    public void helper(TreeNode root, List<Integer> inOrderList) {
        if(root == null) return;

        helper(root.left, inOrderList);
        inOrderList.add(root.val);
        helper(root.right, inOrderList);
    }
}