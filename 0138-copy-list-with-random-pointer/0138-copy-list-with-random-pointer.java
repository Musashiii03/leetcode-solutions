/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node tail = dummy;
        HashMap<Node, Node> map = new HashMap<>();
        Node head1 = head;
        while(head1 != null){
            tail.next = new Node(head1.val);
            tail = tail.next;
            map.put(head1, tail);
            head1 = head1.next;
        }
        Node tail2 = dummy.next;
        Node head2 = head;
        while(tail2 != null && head2 != null){
            tail2.random = map.get(head2.random);
            tail2 = tail2.next;
            head2 = head2.next;
        }
        Node newHead = dummy.next;
        return newHead;
    }
}
