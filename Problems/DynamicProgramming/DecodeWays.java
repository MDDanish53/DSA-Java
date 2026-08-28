class DecodeWays {
  public int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i <= n; i++) {
      int oneDigit = Integer.valueOf(s.substring(i - 1, i)); // current (1 digit)
      int twoDigit = Integer.valueOf(s.substring(i - 2, i)); // prevDigit and current (2 digits)

      // if oneDigit is valid then add dp[i-1] to dp[i]
      if (oneDigit > 0) {
        dp[i] += dp[i - 1];
      }

      // if twoDigit is valid then add dp[i-2] to dp[i]
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[n];
  }
}