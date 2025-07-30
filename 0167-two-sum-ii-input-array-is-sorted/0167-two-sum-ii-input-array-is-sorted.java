class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            int need = target - numbers[i];
            if (map.containsKey(need)) {
                if (map.get(need) == i + 1) {
                    continue;
                }
                return new int[] {map.get(numbers[i]), map.get(need)};
            }
        }
        return new int[] {};
    }
}