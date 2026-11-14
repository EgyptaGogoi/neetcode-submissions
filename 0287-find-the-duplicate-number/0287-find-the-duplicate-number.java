// Floyd Algo
class Solution {
    public int findDuplicate(int[] nums) {
        // first find the the meeting point of fast and slow
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
    // then find the intersection point from the meeting point travelling both the pointers by 1
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna