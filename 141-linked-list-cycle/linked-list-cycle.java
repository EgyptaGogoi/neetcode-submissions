/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast != null && fast.next != null && fast.next.next != null){
            // System.out.print("slow : "+slow.val);
            // System.out.println(" fast : "+fast.val);
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }
        return false;
    }
}