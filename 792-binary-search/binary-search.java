class Solution {
    public int BS(int l, int r, int[]nums, int target){
        if(l > r)
            return -1;
        int mid = l + (r-l)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] < target)
            return BS(mid+1, r, nums, target);
        return BS(l, mid-1, nums, target);
    }
    public int search(int[] nums, int target) {
        return BS(0, nums.length -1, nums, target);
    }
}