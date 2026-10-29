class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer,Integer> ele : freq.entrySet()){
            int[] elem = new int[]{ele.getKey(), ele.getValue()};
            pq.add(elem);

            if (pq.size() > k)
                pq.poll();
        }
        int[] ans = new int[k];
        for(int i =0; i<k; i++)
            ans[i]=pq.poll()[0];
        return ans;
    }
}