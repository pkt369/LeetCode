class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int m = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            ans[i] = ans[i] * m;
            m *= nums[i];
        }
        // System.out.println(Arrays.toString(ans));
        return ans;
    }
}