class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1)
            return 1;
        int[][] newSpeed = new int[n][2];
        for (int i=0; i<position.length; i++){
            newSpeed[i][0] = position[i];
            newSpeed[i][1] = speed[i];
        }
        // only sort the position (desc)
        Arrays.sort(newSpeed, (a, b) -> Integer.compare(b[0], a[0]));
        
        double max = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            double time = (double)(target - newSpeed[i][0])/newSpeed[i][1];
            if(time > max){
                ans++;
                max = time;
            }
        }
        return ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna