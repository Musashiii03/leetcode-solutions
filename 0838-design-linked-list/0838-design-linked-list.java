class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if(size == 0 || index >= size || index < 0)
            return -1;
        Node traverse = head;
        for(int i = 0; i < index; i++)
            traverse = traverse.next;
        return traverse.val;
    }
    
    public void addAtHead(int val) {
        Node dummy = new Node(val);
        Node temp = head;
        dummy.next = temp;
        head = dummy;
        size++;
    }
    
    public void addAtTail(int val) {
        if(size == 0){
            head = new Node(val);
            head.next = null;
        } else {
            Node traverse = head;
            while(traverse.next != null)
                traverse = traverse.next;
            traverse.next = new Node(val);
            traverse.next.next = null;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index <= size && index >= 0){
            if(index == 0){
                Node temp = new Node(val);
                temp.next = head;
                head = temp;
            } else if(index == size){
                Node traverse = head;
                while(traverse.next != null)
                    traverse = traverse.next;
                traverse.next = new Node(val);
                traverse.next.next = null;
            } else {
                Node traverse = head;
                for(int i = 0; i < index - 1; i++)
                    traverse = traverse.next;
                Node temp = traverse.next;
                traverse.next = new Node(val);
                traverse.next.next = temp;
            }
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index < size && index >= 0){
            if(index == 0)
                head = head.next;
            else{
                Node traverse = head;
                for(int i = 0; i < index - 1; i++)
                    traverse = traverse.next;
                traverse.next = traverse.next.next;
            }
            size--;
        }
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