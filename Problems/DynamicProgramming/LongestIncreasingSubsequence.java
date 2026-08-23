class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {

    int[] T = new int[nums.length];

    // start main pointer
    for (int i = 1; i < nums.length; i++) {

      // start second pointer
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          if (T[j] + 1 > T[i]) {
            T[i] = T[j] + 1;
          }
        }
      }
    }

    // find the max value
    int maxLength = 0;
    for (int i = 0; i < T.length; i++) {
      if (T[i] > maxLength) {
        maxLength = T[i];
      }
    }

    return maxLength + 1;

  }
}