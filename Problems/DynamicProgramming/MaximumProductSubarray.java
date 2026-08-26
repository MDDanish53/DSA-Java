class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int minProduct = nums[0], maxProduct = nums[0];
        int maximumProduct = maxProduct;
        for (int i = 1; i < nums.length; i++) {
            int temp = minProduct;
            minProduct = Math.min(nums[i], Math.min(minProduct * nums[i], maxProduct * nums[i]));
            maxProduct = Math.max(nums[i], Math.max(temp * nums[i], maxProduct * nums[i]));
            maximumProduct = Math.max(maxProduct, maximumProduct);
        }
        return maximumProduct;
    }
}