class MinimumWindowSubstring {
  public String minWindow(String s, String t) {

    HashMap<Character, Integer> freqMap = new HashMap<>();

    // Store the frequency of t's characters
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    int uniqueCharCount = freqMap.size();
    int startIndex = -1;
    int windowStart = 0;
    int windowEnd = 0;
    int minLen = Integer.MAX_VALUE;
    int N = s.length();

    while (windowEnd < N) {

      // Expansion: Include the current character in the window
      char ch = s.charAt(windowEnd);

      if (freqMap.containsKey(ch)) {
        freqMap.put(ch, freqMap.get(ch) - 1);

        // If frequency becomes zero, this character's required frequency is completely fulfilled
        if (freqMap.get(ch) == 0) {
          uniqueCharCount--;
        }
        // If frequency becomes negative, the window contains extra occurrences of this character
      }

      // Shrinking: Try to minimize the valid window
      while (uniqueCharCount == 0) {

        int len = windowEnd - windowStart + 1;

        // Update the minimum window if the current one is smaller
        if (len < minLen) {
          minLen = len;
          startIndex = windowStart;
        }

        ch = s.charAt(windowStart);

        if (freqMap.containsKey(ch)) {
          freqMap.put(ch, freqMap.get(ch) + 1);

          // If frequency becomes positive, the window has fewer occurrences of this character than required
          if (freqMap.get(ch) > 0) {
            uniqueCharCount++;
          }
        }

        // Move the window's starting position forward
        windowStart++;
      }

      // Expand the window by moving the ending position forward
      windowEnd++;
    }

    // Return an empty string if no valid window exists
    if (startIndex == -1) {
      return "";
    }

    // Return the minimum window substring
    return s.substring(startIndex, startIndex + minLen);
  }
}