class TimeMap {
    Map<String, List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimeValue> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new TimeValue(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<TimeValue> list = map.get(key);
        int left = 0, right = list.size() - 1;

        String ans = "";
        int max = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (timestamp >= list.get(mid).timestamp) {
                left = mid + 1;
                if (max < mid) {
                    ans = list.get(mid).value;
                    max = mid;
                }
                continue;
            }
            right = mid - 1;
        }
        return ans;
    }
}

class TimeValue {
    String value;
    int timestamp;

    public TimeValue(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */