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
    public int pairSum(ListNode head) {
        ListNode fast = head.next, slow = new ListNode(head.val);
        int max = 0;
        while(fast.next!=null && fast.next.next!=null){
            head = head.next;
            slow = new ListNode(head.val, slow);
            fast = fast.next.next;
        }
        head = head.next;
        while(slow!=null){
            max = Math.max(max, slow.val+head.val);
            slow = slow.next;
            head = head.next;
        }
        return max;
    }
}