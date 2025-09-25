class Solution {
    public int addDigits(int num) {
        while (num / 10 > 0) {
            int copy = num;
            int sum = 0;
            while (copy > 0) {
                sum += copy % 10;
                copy /= 10;
            }
            num = sum;
        }
        return num;
    }
}