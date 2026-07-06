import java.util.HashMap;

class LRUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;
    }

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.prev = null;
        head.next = tail;
        tail.next = null;
        tail.prev = head;
    }

    public void remove(Node node){
        Node temp = node.prev;
        node.prev.next = node.next;
        node.next.prev = temp;
    }

    public void insertAfterHead(Node node){
        Node first = head.next;
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insertAfterHead(node);
            return node.value;
        } else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            remove(map.get(key));
            insertAfterHead(map.get(key));
        } else if(!map.containsKey(key) && map.size() != capacity){
            Node node = new Node();
            node.key = key;
            node.value = value;
            map.put(key, node);
            insertAfterHead(node);
        } else {
            Node lru = tail.prev;
            map.remove(lru.key);
            remove(lru);
            Node node = new Node();
            node.key = key;
            node.value = value;
            map.put(key, node);
            insertAfterHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */