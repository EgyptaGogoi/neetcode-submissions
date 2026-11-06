class TimeMap {
    class Pair {
        int timestamp;
        String val;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.val = value;
        }
    }

    HashMap<String, ArrayList<Pair>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
         hm.computeIfAbsent(key, k -> new ArrayList<>())
      .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key))
            return "";
        
        String ans = "";
        ArrayList<Pair> ls = hm.get(key);
        int l = 0;
        int r = ls.size() - 1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(ls.get(mid).timestamp == timestamp)
                return ls.get(mid).val;
            else if(ls.get(mid).timestamp < timestamp){
                ans = ls.get(mid).val;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna