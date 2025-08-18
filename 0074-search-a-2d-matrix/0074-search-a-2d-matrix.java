class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int left = 0, right = colLength * rowLength - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int y = mid / colLength;
            int x = mid % colLength;
            // System.out.println("left: " + left + ", right: " + right + ", y: " + y + ", x: " + x);
            if (matrix[y][x] > target) {
                right = mid - 1;
                continue;
            }
            if (matrix[y][x] < target) {
                left = mid + 1;
                continue;
            }
            return true;
        }

        return false;
    }
}