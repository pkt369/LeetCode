class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        String standard = strs[0];
        int index = 0;
        while (index < standard.length()) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index) {
                    return ans;
                }
                if (strs[i].charAt(index) != standard.charAt(index)) {
                    return ans;
                }
            }

            ans += standard.charAt(index);
            index++;
        }
        return ans;
    }
}