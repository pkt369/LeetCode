// (오른쪽 - 왼쪽) * min(height[오른쪽], height[왼쪽])
// two pointer
// 1. 왼쪽, 오른쪽 서로 끝에서 시작
// 2. 더 작은쪽을 옮기기
// 3. 계속 옮기기
// 예상 시간 복잡도: O(n)
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int water = (right - left) * Math.min(height[left], height[right]);
            // System.out.println("left: " + left + ", right: " + right + ", water: " + water);
            maxWater = Math.max(maxWater, water);
            
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}