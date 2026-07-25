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
        ListNode first = head;
        ListNode second = head.next;
        int current = head.val;
        while(second != null){
            if(second.val == current){
                first.next = second.next;
                second = first.next;
            } else {
                first = first.next;
                second = second.next;
            }
            current = first.val;
        }
        return head;
    }
}