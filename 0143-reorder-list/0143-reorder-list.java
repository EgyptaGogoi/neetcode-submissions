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
    public void reorderList(ListNode head) {
         if (head == null || head.next == null) {
            return;
        }
        // find middle half
        ListNode slow=head;
        ListNode fast=head;
        while (fast!= null && fast.next!= null){
            fast=fast.next.next;
            slow=slow.next;
        }

        // from middle half to a reverse linkedlist
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while(curr!=null){
            ListNode node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }

        // merge the 2 list 1->2->3->x and 5->4->x
        ListNode left = head;
        ListNode right = prev;
        while(right != null){
            ListNode nextL = left.next;
            ListNode nextR = right.next;
            left.next = right;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna