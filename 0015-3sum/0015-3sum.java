class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                while (left < right && left != i + 1 && nums[left - 1] == nums[left]) left++;
                while (left < right && right != nums.length - 1 && nums[right + 1] == nums[right]) right--;

                if (left >= right) {
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    continue;
                }
                if (sum > 0) {
                    right--;
                    continue;
                }
                left++;
            }
        }
        return ans;
    }
}