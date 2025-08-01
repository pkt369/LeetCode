class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = getLeftSide();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                stack.add(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (!isFair(stack.pop(), c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private Set<Character> getLeftSide() {
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        return set;
    }

    private boolean isFair(char left, char right) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        if (!map.containsKey(left)) {
            throw new RuntimeException("error");
        }
        return map.get(left) == right;
    }
}