class PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }

    // if the total sum is odd, its not possible to partition it into two equal sum subsets
    if (total % 2 != 0) {
      return false;
    }

    int target = total / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true; // there's always a way to make up sum 0 with an empty subset

    // process each number in the array
    for (int num : nums) {
      // go backward to prevent using the same element more than once
      for (int j = target; j >= num; j--) {
        if (dp[j - num]) {
          dp[j] = true;
        }
      }
    }
    return dp[target];
  }
}