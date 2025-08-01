import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            char c = tokens[i].charAt(tokens[i].length() - 1);
            if (Character.isDigit(c)){
                stack.add(Integer.parseInt(tokens[i]));
                continue;
            }

            int num1 = stack.pop();
            int num2 = stack.pop();
            if (c == '+') {
                stack.add(num2 + num1);
            } else if (c == '-') {
                stack.add(num2 - num1);
            } else if (c == '/') {
                stack.add(num2 / num1);
            } else {
                stack.add(num2 * num1);
            }
        }
        return stack.pop();
    }
}