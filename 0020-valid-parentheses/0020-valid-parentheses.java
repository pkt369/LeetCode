// key point: 열리는 괄호가 있으면 닫히는 괄호도 있어야 한다.
// stack 을 통해 해결한다.
// 짝은 map 으로 미리 정의해둔다.
// 시간복잡도: O(n)
// deque 에서 push = 앞에 넣기, pop = 앞에서 빼기, peek() = 앞보기
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
                continue;
            }
            if (stack.size() == 0) {
                return false;
            }
            if (stack.peekLast() != map.get(c)) {
                return false;
            }
            stack.removeLast();
        }
        return stack.size() == 0;
    }
}