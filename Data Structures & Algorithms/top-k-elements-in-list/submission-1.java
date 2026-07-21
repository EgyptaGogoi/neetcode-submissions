class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int ele : nums){
            hm.put(ele, hm.getOrDefault(ele, 0)+1);
            if (!ans.contains(ele) && hm.get(ele) >=k)
                ans.add(ele);
            // System.out.println(ans);
        }
        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
