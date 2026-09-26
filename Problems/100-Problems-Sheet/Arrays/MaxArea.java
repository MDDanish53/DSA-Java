package Arrays;

class MaxArea {

  public int maxArea(int nums[]) {
    int max_area = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int height = Math.min(nums[i], nums[j]);
        int width = j - i;
        int area = height * width;
        if (area > max_area) {
          max_area = area;
        }
      }
    }

    return max_area;
  }

  public int maxArea2(int height[]) {
    int area = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return area;
  }

  void main(String args[]) {
    int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    int result = maxArea2(height);
    System.out.println(result);
  }
}