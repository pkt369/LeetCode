class Solution {
    int INF = 200000001;
    public int minSpaceWastedKResizing(int[] nums, int k) {
        return findWasted(nums, new Integer[nums.length][k + 1], k, 0);
    }

    public int findWasted(int[] nums, Integer[][] memo, int k, int index) {
        if (index == nums.length) {
            return 0;
        }
        if (k == -1) {
            return INF;
        }
        if (memo[index][k] != null) {
            return memo[index][k];
        }

        int sum = 0, max = 0, minWasted = INF;
        for (int i = index; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
            int wasted = max * (i - index + 1) - sum;
            minWasted = Math.min(minWasted, findWasted(nums, memo, k - 1, i + 1) + wasted);
        }
        memo[index][k] = minWasted;
        return minWasted;
    }
}