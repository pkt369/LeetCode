class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }

            if (isSameWord(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isSameWord(String haystack, String needle, int index) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(i + index) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}