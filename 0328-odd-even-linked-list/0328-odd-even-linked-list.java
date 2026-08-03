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
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null){return head;}

        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        int count = 1;

        ListNode oddHead = odd;
        ListNode evenHead = even;

        while(head != null){
            if(count % 2 != 0){
                odd.next = head;
                odd = odd.next;
            }
            else{
                even.next = head;
                even = even.next;
            }
            head = head.next;
            count++;
        }

        even.next = null;
        odd.next = evenHead.next;

        return oddHead.next;
    }
}