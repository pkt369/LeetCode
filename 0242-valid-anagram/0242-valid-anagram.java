class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
            if (map.get(c1) == 0) {
                map.remove(c1);
            }
            if (map.containsKey(c2) && map.get(c2) == 0) {
                map.remove(c2);
            }
        }
        return map.size() == 0;
    }
}