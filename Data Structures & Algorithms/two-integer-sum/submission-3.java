class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i< nums.length; i++){
            int find = target - nums[i];
            if (hm.containsKey(find)){
                return new int[] {hm.get(find), i};
            }
            hm.put(nums[i], i);
        }
        return ans;
    }
}
