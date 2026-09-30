// Good
class TopKFrequentElementsGood {
  public int[] topKFrequent(int[] nums, int k) {

    int[] res = new int[k];
    Map<Integer, Integer> count = new HashMap<>();

    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    Map<Integer, Integer> orderedCount = new LinkedHashMap<>();

    count.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> orderedCount.put(x.getKey(), x.getValue()));

    for (int i : orderedCount.keySet()) {
      res[res.length - (k--)] = i;
      if (k == 0) {
        break;
      }
    }

    return res;
  }
}

// Better
class TopKFrequentElementsBetter {
  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

    for (int key : map.keySet()) {
      minHeap.add(key);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    int[] res = new int[k];

    while (k-- > 0) {
      res[k] = minHeap.poll();
    }

    return res;
  }
}

// Best
class TopKFrequentElementsBest {
  public int[] topKFrequent(int[] nums, int k) {

    int[] res = new int[k];
    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] buckets = new List[nums.length + 1];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new ArrayList<>();
    }
    for (int key : count.keySet()) {
      buckets[count.get(key)].add(key);
    }
    List<Integer> temp = new ArrayList<>();
    for (int i = buckets.length - 1; i >= 0; i--) {
      List<Integer> list = buckets[i];
      for (int num : list) {
        temp.add(num);
      }
    }
    while (k-- > 0) {
      res[k] = temp.get(k);
    }
    return res;
  }
}