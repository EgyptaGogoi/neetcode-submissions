class Solution {
    // nse and pse in optimal 1-way approach
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int max = 0;
        for(int i =0; i<n; i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int len = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty()? -1 : st.peek();
                int area = len * (nse - pse - 1);
                max = Math.max(max, area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int len = heights[st.pop()];
            int nse = n;
            int pse = st.isEmpty()? -1 : st.peek();
            int area = len * (nse - pse - 1);
            max = Math.max(max, area);
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna