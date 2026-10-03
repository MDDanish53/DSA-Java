class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    int longestLength = 0;
    Map<Integer, Boolean> exploredMap = new HashMap<>();
    for (int num : nums) {
      exploredMap.put(num, false);
    }

    for (int num : nums) {
      int currLength = 1;

      int nextNum = num + 1;
      while (exploredMap.containsKey(nextNum) && !exploredMap.get(nextNum)) {
        currLength++;
        exploredMap.put(nextNum, true);
        nextNum++;
      }

      int prevNum = num - 1;
      while (exploredMap.containsKey(prevNum) && !exploredMap.get(prevNum)) {
        currLength++;
        exploredMap.put(prevNum, true);
        prevNum--;
      }
      longestLength = Math.max(longestLength, currLength);
    }
    return longestLength;
  }
}