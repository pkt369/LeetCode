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
        if (head == null) {
            return head;
        }
        ListNode previous = head;
        ListNode next = head.next;
        while (next != null) {
            while (next != null) {
                if (previous.val != next.val) {
                    break;
                }
                next = next.next;
            }
            previous.next = next;
            if (next != null) {
                next = next.next;
            }
            previous = previous.next;
        }
        return head;
    }
}