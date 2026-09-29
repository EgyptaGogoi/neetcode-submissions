class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0){
            return new int[0];
        }
        PriorityQueue <int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] ans = new int[nums.length - k +1];

        int i = 0;
        int c = 0;

        while(i < nums.length){
           pq.offer(new int[]{nums[i], i});

           while(!pq.isEmpty() && pq.peek()[1]<= i-k){
                pq.poll();
           }
           if(i >= k-1)
                ans[c++] = pq.peek()[0];
           i++;
        }
        return ans;
    }
}