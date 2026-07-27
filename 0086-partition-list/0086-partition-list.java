import java.util.LinkedList;

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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerList = new ListNode();
        ListNode largerList = new ListNode();

        ListNode smaller = smallerList;
        ListNode larger = largerList;

        while(head != null){
            if(head.val < x){
                smaller.next = head;
                smaller = smaller.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        } 
        smaller.next = largerList.next;
        larger.next = null;
        return smallerList.next;
    }
}