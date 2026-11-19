class Solution {
    // \[x_1^2+y_1^2 < x_2^2+y_2^2\]
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)-> Integer.compare(
            (a[0])*(a[0]) + (a[1])*(a[1]), 
            (b[0])*(b[0]) + (b[1])*(b[1])
        ));

        for(int[] i : points){
            pq.add(i);
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna