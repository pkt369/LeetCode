class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int ans = 0;
        Set<Integer> isUsed = new HashSet<>();

        for (Integer num: set) {
            if (isUsed.contains(num)) {
                continue;
            }
            int count = 1;
            int left = num - 1, right = num + 1;
            while (set.contains(left)) {
                count++;
                isUsed.add(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                isUsed.add(right);
                right++;
            }

            ans = Math.max(ans, count);
        }
        return ans;
    }
}