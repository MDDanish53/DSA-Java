class Solution {
  public int[] productExceptSelf(int[] nums) {

    // Array to store all left elements multiplication except curr
    int[] left = new int[nums.length];

    // Array to store all right elements multiplication except curr
    int[] right = new int[nums.length];

    left[0] = 1; // first element has no left elements

    for (int i = 1; i < nums.length; i++) {
      left[i] = left[i - 1] * nums[i - 1];
    }

    right[nums.length - 1] = 1; // last element has no right elements

    for (int i = nums.length - 2; i > -1; i--) {
      right[i] = right[i + 1] * nums[i + 1];
    }

    int[] res = new int[nums.length];

    // multiply both left and right products of curr to get the whole product except curr element
    for (int i = 0; i < nums.length; i++) {
      res[i] = left[i] * right[i];
    }

    return res;

  }
}