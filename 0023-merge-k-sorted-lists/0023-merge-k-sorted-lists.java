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
    public ListNode merge2Lists(ListNode head1, ListNode head2){
        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            }
            else{
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }
        if(head1 != null){
            curr.next = head1;
        }

        if(head2 != null){
            curr.next = head2;
        }
        return newHead.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length ==0)
            return null;

        if(lists.length ==1)
            return lists[0];

        ListNode newHead = lists[0];

        for(int i=1; i<lists.length; i++){
            newHead = merge2Lists(newHead,lists[i]);
        }

        return newHead;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna