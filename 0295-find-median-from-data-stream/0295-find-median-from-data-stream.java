class MedianFinder {
    PriorityQueue<Integer> maxLeft;
    PriorityQueue<Integer> minRight;

    public MedianFinder() {
        maxLeft = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        minRight = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!maxLeft.isEmpty() && num <= maxLeft.peek())
            maxLeft.add(num);
        else
            minRight.add(num);
        
        if(maxLeft.size() > minRight.size()+1)
            minRight.add(maxLeft.poll());
        else if (minRight.size() > maxLeft.size())
            maxLeft.add(minRight.poll());
        
        return ;
    }
    
    public double findMedian() {
        if(maxLeft.size() > minRight.size())
            return maxLeft.peek();
        return (maxLeft.peek()+minRight.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna