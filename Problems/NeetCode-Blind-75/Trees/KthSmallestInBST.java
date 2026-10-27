
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

class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();

        inOrder(root, nums);
        return nums.get(k-1);
    }

    public void inOrder(TreeNode root, List<Integer> nums) {
        if(root == null ){
            return;
        }

        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}