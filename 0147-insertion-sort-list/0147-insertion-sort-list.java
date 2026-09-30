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
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null){return null;}
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = head;
        head = head.next;
        
        while(head != null){

            if (prev.val <= head.val){
                prev = head;
                head = head.next;
                continue;
            }

            ListNode next = head.next; 
            prev.next = next;

            ListNode traverse = dummy;
            while(traverse.next != null && traverse.next.val < head.val)
                traverse = traverse.next;

            head.next = traverse.next;
            traverse.next = head;
            head = next;
        }
        
        return dummy.next;
    }
}