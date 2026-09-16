class Solution {
    public int maxArea(int[] nums) {
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int max_v = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i<j){
            int min_height = Math.min(nums[i], nums[j]);
            int curr_v= min_height * (j-i);
            max_v = Math.max(curr_v, max_v);
            if(nums[i] > nums[j])
                j--;
            else
                i++;
        }
        return max_v;
    }
}

