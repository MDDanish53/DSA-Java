import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) { // "leetcode"

    // Convert the dictionary to a set for O(1) lookups
    Set<String> wordSet = new HashSet<>(wordDict); // ["leet", "code"]

    // find the maximum word length in the dictionary
    int maxLen = 0; // 4
    for (String word : wordDict) {
      maxLen = Math.max(maxLen, word.length());
    }

    int n = s.length(); // 8
    // dp[i] states if the substring can be segmented
    boolean[] dp = new boolean[n + 1]; // 9

    // base case : empty string is valid
    dp[0] = true; // [T,F,F,F,T,F,F,F,T]

    for (int i = 1; i <= n; i++) { // 8

      // check prefixes of length up to maxLen
      for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) { // 4, 4
        if (dp[j] && wordSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break; // no need to check further prefixes
        }
      }
    }
    return dp[n];
  }
}