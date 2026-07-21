class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int ele : nums){
            hm.put(ele, hm.getOrDefault(ele, 0)+1);
        }
        List<Integer> keys = new ArrayList<>(hm.keySet()); 
        keys.sort((a, b) -> hm.get(b) - hm.get(a));

        int[] ans = new int[k];
        for (int m = 0; m<k; m++)
            ans[m]= keys.get(m);
        return ans;
    }
}
