class Solution {
    // Increasing monotonic stack for smaller elements
    public int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            nse[i]= st.isEmpty()? n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPSE(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            pse[i]= st.isEmpty()? -1:st.peek();
            st.push(i);
        }
        return pse;
    }

    public int largestRectangleArea(int[] heights) {
        //Brute force implement NSE and PSE in 2 pass
        int n = heights.length;

        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);

        int max = 0;
        for(int i = 0; i<n; i++){
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(area,max);
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna