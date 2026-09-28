class TwoSum {
  public int[] twoSum(int[] nums, int target) {

    // Create a HashMap
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      // Get the complement using the target value
      int compliment = target - nums[i];

      // Search the hashmap for complement, if found, we got our pair
      if (map.containsKey(compliment)) {
        return new int[] { map.get(compliment), i };
      }

      // Put the element in hashmap for subsequent searches
      map.put(nums[i], i);
    }
    return new int[] { -1, -1 };
  }
}