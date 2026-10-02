class MinStack {
    Stack<Integer> st;
    PriorityQueue<Integer> pq;
    public MinStack() {
        st = new Stack<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int value) {
        st.push(value);
        pq.add(value);
    }
    
    public void pop() {
        pq.remove(st.peek());
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */