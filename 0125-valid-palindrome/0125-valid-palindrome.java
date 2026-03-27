class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.reverse();
        
        return sb.toString().equals(sb2.toString());
    }
}