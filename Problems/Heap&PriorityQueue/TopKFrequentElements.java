class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {

    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    List<Integer>[] buckets = new List[nums.length + 1];

    for (int num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    for (int key : frequencyMap.keySet()) {
      int frequency = frequencyMap.get(key);
      if (buckets[frequency] == null) {
        buckets[frequency] = new ArrayList<>();
      }
      buckets[frequency].add(key);
    }

    int[] res = new int[k];
    int count = 0;
    for (int pos = buckets.length - 1; pos >= 0 && count < k; pos--) {
      if (buckets[pos] != null) {
        for (int val : buckets[pos]) {
          res[count++] = val;
        }
      }
    }
    return res;
  }
}