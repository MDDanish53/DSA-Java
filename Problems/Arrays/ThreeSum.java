package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ThreeSum {

  public List<List<Integer>> threeSum(int nums[]) {

    // sort the array elements
    Arrays.sort(nums);
    Set<List<Integer>> result = new HashSet<>();

    // now fix the first element and find the other two elements
    for (int i = 0; i < nums.length - 2; i++) {

      // find other two elements using two sum approach
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return new ArrayList<>(result);
  }

  public List<List<Integer>> threeSum1(int nums[]) {
    Arrays.sort(nums);
    Set<List<Integer>> result = new HashSet<>();

    for(int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while(left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if(sum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
        } else if(sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    return new ArrayList<>(result);
  }

  void main() {
    int nums[] = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> result = threeSum1(nums);
    for (List<Integer> res : result) {
      System.out.println(res);
    }
  }
}