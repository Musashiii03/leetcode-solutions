/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode previous = dummy;
        ListNode current = head;

        while(current != null){
            if(current.next != null && current.val == current.next.val){
                while(current.next != null && current.val == current.next.val)
                    current = current.next;
                current = current.next;
                previous.next = current;
            } else {
                previous.next = current;
                previous = previous.next;
                current = current.next;
            } 
        }

        return dummy.next;
    }
}