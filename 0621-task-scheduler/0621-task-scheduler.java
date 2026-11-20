class Solution {
    // PriorityQueue + Queue approach
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks)
            freq[c-65]++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int f : freq){
            if(f>0)
                maxHeap.add(f);
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;

        while(!queue.isEmpty() || !maxHeap.isEmpty()){
            if(!queue.isEmpty() && queue.peek()[1] <= time)
                maxHeap.add(queue.poll()[0]);

            if(!maxHeap.isEmpty()){
                int retask = maxHeap.poll()-1;
                int nextime = time + n + 1;
                if(retask > 0)
                    queue.add(new int[]{retask, nextime});
            }

            time++;
           
        }

        return time;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna