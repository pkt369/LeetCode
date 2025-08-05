class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        Stack<Temperature> stack = new Stack<>();
        stack.add(new Temperature(temperatures[0], 0));
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty()) {
                Temperature compare = stack.peek();
                if (compare.value >= temperatures[i]) {
                    break;
                }
                ans[compare.index] = i - compare.index;
                stack.pop();
            }

            stack.add(new Temperature(temperatures[i], i));
        }

        while (!stack.isEmpty()) {
            Temperature temperature = stack.pop();
            ans[temperature.index] = 0;
        }
        return ans;
    }
}

class Temperature {
    int value;
    int index;

    public Temperature(int value, int index) {
        this.value = value;
        this.index = index;
    }
}