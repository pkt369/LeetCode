class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int index = s.length() - 1;
        for (; index >= 0; index--) {
            if (s.charAt(index) != ' ') {
                break;
            }
        }
        for (; index >= 0; index--) {
            if (s.charAt(index) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}