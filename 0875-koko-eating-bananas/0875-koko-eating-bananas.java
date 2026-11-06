class Solution {
    public int calHours(int [] piles, int k){
        double sum = 0;
        for (int i = 0; i< piles.length; i++){
            sum += (piles[i] + k - 1) / k;
        }
        return (int) sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for(int p : piles)
            r = Math.max(r, p);
        
        int l = 1;
        while(l<=r){
            int mid = l + (r-l)/2;

            int hours = calHours(piles, mid);

            if(hours<=h)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna