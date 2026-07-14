class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i< nums.length; i++)
            hm.put(nums[i], i);
        for (int i = 0; i< nums.length; i++){
            int find = target - nums[i];
            if (hm.containsKey(find) && hm.get(find) !=i){
                ans[0] = i;
                ans[1] = hm.get(find);
                return ans;
            }
        }
        return ans;
    }
}
