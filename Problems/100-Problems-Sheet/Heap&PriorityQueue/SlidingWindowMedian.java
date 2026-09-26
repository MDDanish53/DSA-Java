class SlidingWindowMedian {

  TreeSet<Integer> minHeap, maxHeap;

  public double[] medianSlidingWindow(int[] nums, int k) {

    Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
    minHeap = new TreeSet<>(comparator);
    maxHeap = new TreeSet<>(comparator.reversed());

    double[] result = new double[nums.length - k + 1];

    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
      if (i >= k) {
        minHeap.remove(i - k);
        maxHeap.remove(i - k);
      }

      // always add value to minHeap first
      minHeap.add(i);
      // shift first value from minHeap to maxHeap
      maxHeap.add(minHeap.pollFirst());

      // balance both heaps
      balanceHeaps();

      if (i >= k - 1) {
        result[ans++] = calculateMedian(nums, k);
      }
    }

    return result;
  }

  public Double calculateMedian(int[] nums, int k) {
    if (k % 2 == 0) {
      return ((double) nums[minHeap.first()] + nums[maxHeap.first()]) / 2;
    }
    return (double) nums[minHeap.first()];
  }

  public void balanceHeaps() {
    if (minHeap.size() < maxHeap.size())
      minHeap.add(maxHeap.pollFirst());
  }
}