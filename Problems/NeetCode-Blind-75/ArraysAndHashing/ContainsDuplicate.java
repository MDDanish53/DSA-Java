public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> intSet = new HashSet<>();

    for (int num : nums) {
      // if set contains the num means it is repeated, so return true
      if (intSet.contains(num)) {
        return true;
      }
      // add the num to the set
      intSet.add(num);
    }

    return false;
  }
}
