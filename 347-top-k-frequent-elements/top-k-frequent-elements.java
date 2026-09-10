class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int l = nums.length;
        for(int i = 0; i<l; i++)
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) +1);
        List<Integer>[] bucket = new ArrayList[l+1];
        for(int key : hm.keySet()){
            if (bucket[hm.get(key)] == null)
                bucket[hm.get(key)] = new ArrayList<>();
            bucket[hm.get(key)].add(key);
        }
       
        int ind = 0;
        int[] ans = new int[k];
        for( int i = l; i> 0 && ind < k; i--){
            if (bucket[i] != null){
                for(int ele : bucket[i]){
                    if(ind == k) break;
                    ans[ind++] = ele;
                }
            }
        }
        return ans;
    }
}