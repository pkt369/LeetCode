class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0, sum = nums[0], max = nums[0];
        for (int right = 1; right < nums.length; right++) {
            if (sum < 0) {
                sum = nums[right];
                max = Math.max(max, sum);
                continue;
            }
            sum += nums[right];
            max = Math.max(max, sum);
        }
        return max;
    }
}