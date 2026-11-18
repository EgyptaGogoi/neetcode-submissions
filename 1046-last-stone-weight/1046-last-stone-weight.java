class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones)
            pq.add(stone);

        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a-b);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna