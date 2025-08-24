class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int count = 0;
        for (int right = 0; right < s2.length(); right++) {
            if (!map.containsKey(s2.charAt(right))) {
                count = 0;
                while (left <= right) {
                    if (map.containsKey(s2.charAt(left))) {
                        map.put(s2.charAt(left), map.get(s2.charAt(left)) + 1);
                    }

                    left++;
                }
                continue;
            }

            while (map.get(s2.charAt(right)) == 0) {
                map.put(s2.charAt(left), map.get(s2.charAt(left)) + 1);
                left++;
                count--;
            }

            map.put(s2.charAt(right), map.get(s2.charAt(right)) - 1);
            count++;
            if (count == s1.length()) {
                return true;
            }
        }

        return false;
    }
}