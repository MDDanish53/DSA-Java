package Arrays;

class MissingNumber {

  public int missingNumber(int nums[]) {
    int n = nums.length;
    int expected = n * (n + 1) / 2;
    int actualSum = 0;

    for(int num : nums) {
      actualSum += num;
    }

    return expected - actualSum;
  }

  void main() {
    int nums[] = {9,6,4,2,3,5,7,0,1};
    System.out.print(missingNumber(nums));
  }
}