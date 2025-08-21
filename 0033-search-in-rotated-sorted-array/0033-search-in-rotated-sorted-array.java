class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // System.out.println("mid: " + mid + ", value: " + nums[mid]);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                    continue;
                }
                left = mid + 1;
                continue;
            }

            // here is ascending order
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        return -1;
    }
}