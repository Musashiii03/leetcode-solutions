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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode trav = head;
        ListNode beforeLeft;

        int i = 1;

        if(left == 1){
            beforeLeft = null;
        } else {
            beforeLeft = head;
            while(i < left){
                beforeLeft = trav;
                trav = trav.next;
                i++;
            }
        }
        ListNode leftNode = trav;

        while(i < right){
            trav = trav.next;
            i++;
        }
        ListNode afterRight = trav.next;

        ListNode curr = leftNode;
        ListNode prev = null;
        
        while(curr != afterRight){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(left == 1)
            head = prev;
        else
            beforeLeft.next = prev;
            
        leftNode.next = afterRight;
        
        return head;
    }
}