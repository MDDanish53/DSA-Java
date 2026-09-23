class SmallestRangeCoveringElementsfromKLists {
  public int[] smallestRange(List<List<Integer>> nums) {
    // [element, listIndex, elementIndex]
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0]; // increasing order
      }
    });

    int k = nums.size();
    int max = Integer.MIN_VALUE;

    // insert first values from each list
    for (int i = 0; i < k; i++) {
      int minValue = nums.get(i).get(0);
      pq.offer(new int[] { minValue, i, 0 });
      max = Math.max(max, minValue);
    }

    int[] minRange = { 0, Integer.MAX_VALUE };

    // compare current range with new range and take the minimum range
    while (true) {
      int[] top = pq.poll();
      int minElement = top[0], listIndex = top[1], elementIndex = top[2];
      if (max - minElement < minRange[1] - minRange[0]) {
        minRange[0] = minElement;
        minRange[1] = max;
      }
      if (elementIndex == nums.get(listIndex).size() - 1)
        break;
      int next = nums.get(listIndex).get(elementIndex + 1);
      max = Math.max(max, next);
      pq.offer(new int[] { next, listIndex, elementIndex + 1 });
    }

    return minRange;

  }
}