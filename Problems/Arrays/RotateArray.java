package Arrays;
class RotateArray {

public void rotateArray(int nums[], int k) {

  k = k % nums.length;
  
  //1. reverse the whole array
  reverse(nums, 0, nums.length - 1);

  //2. reverse the right side shifted elements
  reverse(nums, 0, k - 1);

  //3. reverse the remaining elements
  reverse(nums, k, nums.length - 1);
}

public void reverse(int nums[], int start, int end) {
  while(start <= end) {
    int temp = nums[start];
    nums[start] = nums[end];
    nums[end] = temp;
    start++;
    end--;
  }
}

  void main() { // 7, 6, 5, 4, 3, 2, 1
    int nums[] = {1,2,3,4,5,6,7}; // 5, 6, 7, 1, 2, 3, 4
    int k = 3;

    System.out.print("Before applying rotation -> ");
    for(int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
    rotateArray(nums, k);

    System.out.print("After applying rotation -> ");
    for(int num : nums) {
      System.out.print(num + " ");
    }
  }
}