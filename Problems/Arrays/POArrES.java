package Arrays;


class POArrES {

  public int[] productExceptSelf1(int nums[]) {
    int prefix[] = new int[nums.length];
    int suffix[] = new int[nums.length];
    int answer[] = new int[nums.length];

    // getting the product of all the elements at the left side of the current element
    prefix[0] = 1; // because there are no elements at the left side of the first array element
    for(int i = 1; i < nums.length; i++) { // prefix = [1, 1, 2, 6]
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    // getting the product of all the elements at the ride side of the current element
    suffix[nums.length - 1] = 1; // because there are no elements at the right side of the last array element
    for(int i = nums.length - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i + 1];
    }

    // multiplying current element's prefix and suffix to get the product of all the array elements except the current element's inclusion
    for(int i = 0; i < nums.length; i++) {
      answer[i] = prefix[i] * suffix[i];
    }

    return answer;
  }

  public int[] productExceptSelf(int nums[]) {
    int answer[] = new int[nums.length];

    answer[0] = 1;
    // Prefix values
    for(int i = 1; i < nums.length; i++) {
      answer[i] = answer[i - 1] * nums[i - 1];
    }

    int suffix = 1;
    // Right se left
    for(int j = nums.length - 1; j >= 0; j--) {
      answer[j] = answer[j] * suffix;
      suffix = suffix * nums[j];
    }

    return answer;
  }

  void main() {
    int nums[] = { 1, 2, 3, 4 };
    int result[] = productExceptSelf(nums);

    for (int num : result) {
      System.out.print(num + " ");
    }
  }
}