class Node{
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> hm;
    Node head;
    Node tail;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    public void deletionNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addAfterHead(Node node){
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if(!hm.containsKey(key))
            return -1;
        Node node = hm.get(key);
        deletionNode(node);
        addAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;

            deletionNode(node);
            addAfterHead(node);
        }
        else{
            if(hm.size() == capacity){
                Node node = tail.prev;
                
                hm.remove(node.key);
                deletionNode(node);
            }
            Node node = new Node(key,value);
            addAfterHead(node);
            hm.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna