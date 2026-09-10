class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] pre_prod = new int[n];
        int [] suf_prod = new int[n];

        pre_prod[0] = nums[0];
        suf_prod[n-1] = nums[n-1];
        int i;
        for(i=1; i<n; i++){
            pre_prod[i] = pre_prod[i-1]*nums[i];
        }
        for(i=n-2; i>=0; i--){
            suf_prod[i] = suf_prod[i+1]*nums[i];
        }

        int [] ans = new int[n];
        ans[0] = suf_prod[1];
        ans[n-1] = pre_prod[n-2];
        for(i=1; i<n-1; i++){
            ans[i] = pre_prod[i-1] * suf_prod[i+1];
        }
        return ans;
    }
}

// // 1   2   3   4
// // [ 1, 2, 6, 24]

// // 4   3   2   1
// // [4, 12, 24, 24]
// // [24, 24, 12, 4]

// // 1 x 24 = 24
// 1 x 12 = 12
// 2 x 4 = 8
// 6 x 1 = 6

// -1