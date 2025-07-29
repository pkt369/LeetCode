class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Element> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Element element = map.getOrDefault(nums[i], new Element(nums[i]));
            element.count++;
            map.put(nums[i], element);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (Element el: map.values()) {
            pq.add(el);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Element poll = pq.poll();
            // System.out.println("count: " + poll.count + ", num: " + poll.value);
            ans[i] = poll.value;
        }
        return ans;
    }
}

class Element implements Comparable<Element> {
    int value;
    int count;

    public Element(int value) {
        this.value = value;
    }

    public int compareTo(Element el) {
        return el.count - this.count;
    }
}