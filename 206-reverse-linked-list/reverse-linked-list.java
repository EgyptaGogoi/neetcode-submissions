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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode curr = head;
        ListNode ncurr =  new ListNode(curr.val, null);
        curr = curr.next;
        while(curr != null){
            ListNode nextNode =  new ListNode(curr.val, ncurr);
            ncurr = nextNode;
            curr = curr.next;
        }
        return ncurr;
    }
}