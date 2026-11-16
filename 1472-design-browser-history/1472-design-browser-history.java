class UrlNode {
    String url;
    UrlNode prev;
    UrlNode next;

    public UrlNode(String url){
        this.url = url;
        prev = null;
        next = null;
    }
}
class BrowserHistory {
    String homepage;
    UrlNode head;
    UrlNode tail;

    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        head = new UrlNode(homepage);
        tail = head;
    }
    
    public void visit(String url) {
        UrlNode node = new UrlNode(url);
        if(head.next == null){
            head.next = node;
            node.prev = head;
            
        }
        else{
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        return ;
    }
    
    public String back(int steps) {
        int i =steps;
        while(tail.prev != null && i>0){
            tail = tail.prev;
            i--;
        }
        return tail.url;
    }
    
    public String forward(int steps) {
        int i =0;
        while(tail.next != null && i<=steps-1){
            tail = tail.next;
            i++;
        }
        return tail.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna