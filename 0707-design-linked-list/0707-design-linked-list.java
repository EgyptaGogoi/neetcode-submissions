class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val){
        this.val = val;
        prev = null;
        next = null;
    }
}
class MyLinkedList {
    Node head;
    Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }
    
    public int get(int index) {
        Node curr = head;
        int i = 0;
        while(curr != null){
            if(i == index)
                return curr.val;
            curr = curr.next;
            i++;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = head.prev;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = tail = node;
            return;
        }
        node.prev = tail;
        tail.next = node;
        tail = tail.next;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return ;
        }
        Node curr = head;
        int i = 0;
        while(curr != null){
            if(i == index-1){
                if(curr.next == null){
                    this.addAtTail(val);
                    return ;
                }
                Node node = new Node(val);
                node.prev = curr;
                node.next = curr.next;
                curr.next.prev = node;
                curr.next = node;
                return ;
            }
            curr = curr.next;
            i++;
        }

    }
    
    public void deleteAtIndex(int index) {
        if(index == 0){
            head = head.next;
            if(head != null)
                head.prev = null;
            else
                tail = null;
            return ;
        }

        Node curr = head;
        int i = 0;
        
        while(curr != null && i < index-1){
            curr = curr.next;
            i++;
        }
        if(curr == null || curr.next == null)
            return ;
        
        Node nodeToRemove = curr.next;
        nodeToRemove.prev = null;
        if(nodeToRemove.next == null){
            curr.next = null;
            tail = curr;
            return ;
        }
        curr.next = nodeToRemove.next;
        nodeToRemove.next.prev = curr;
        return ;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna