class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.print("mid: " + mid + ", left: " + left + ", right: " + right);
            long count = 0;
            for (int i = 0; i < piles.length; i++) {
                count += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    count++;
                }
            }
            System.out.println(", count: " + count);
            if (count <= h) {
                ans = Math.min(ans, mid);
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        return ans;
    }
}