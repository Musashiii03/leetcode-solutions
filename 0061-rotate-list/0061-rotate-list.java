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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){return head;}
        int length = 0;
        ListNode count = head;
        while(count != null){
            length++;
            count = count.next;
        }

        k = k % length;
        if(k == 0)
            return head;
        int cut = length - k;

        ListNode tail = head.next;
        ListNode prev = head;
        for(int i = 0; i < cut - 1; i++){
            prev = prev.next;
            tail = tail.next;
        }

        prev.next = null;

        ListNode newHead = tail;
        while(tail.next != null)
            tail = tail.next;
        tail.next = head;

        return newHead;
    }
}