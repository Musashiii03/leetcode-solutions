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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;
        ListNode result = new ListNode();
        ListNode resultHead = result;

        while(head1 != null || head2 != null || carry != 0){
            int digit1 = (head1 == null) ? 0 : head1.val;
            int digit2 = (head2 == null) ? 0 : head2.val;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            resultHead.next = new ListNode(sum % 10);
            resultHead = resultHead.next;
            head1 = (head1 != null) ? head1.next : null;
            head2 = (head2 != null) ? head2.next : null;
        }
        return result.next;
    }
}