class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int min = 5000;
        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[l]<= nums[r]){
                min = Math.min(min, nums[l]);
                break;
            }
            else if(nums[mid] >= nums[l])
                l = mid + 1;
            else
                r = mid;
        }
        return min;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna