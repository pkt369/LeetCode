class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Number> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Number(nums[i], i));
        }
        Collections.sort(list);

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (list.get(left).value + list.get(right).value < target) {
                left++;
                continue;
            }
            if (list.get(left).value + list.get(right).value > target) {
                right--;
                continue;
            }
            return new int[] {list.get(left).index, list.get(right).index};
        }
        return new int[]{};
    }
}

class Number implements Comparable<Number> {
    int value;
    int index;

    public Number(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Number num) {
        return this.value - num.value;
    }
}