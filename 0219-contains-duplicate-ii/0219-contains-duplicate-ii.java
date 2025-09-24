class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indics = map.getOrDefault(nums[i], new ArrayList<>());
            indics.add(i);
            map.put(nums[i], indics);
        }

        for (Integer num: map.keySet()) {
            List<Integer> indics = map.get(num);
            if (indics.size() == 1) {
                continue;
            }
            
            for (int i = 1; i < indics.size(); i++) {
                System.out.println("first: " + indics.get(i) + ", second: " + indics.get(i - 1));
                if (indics.get(i) - indics.get(i - 1) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}