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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        while(curr!= null){
            curr= curr.next;
            n++;
        }

        int totGrp = n/k;
        int i = k;
        int curri = 0;

        curr = head;
        ListNode prev = null;
        ListNode tempH = curr;
        ListNode newHead = null;
        ListNode grpPrev = null;
        
        while(curr != null && tempH!= null && curri <totGrp){
            tempH = curr;

            while(curr != null && i>0){
                ListNode dummy = curr.next;
                curr.next = prev;
                prev = curr;
                curr = dummy;
                i--;
            }

            if(curri == 0)
                newHead = prev;
            else{
                grpPrev.next = prev;
            }

            tempH.next = curr;
            grpPrev = tempH;
            prev = null;
            i=k;
            curri++;
        }

        return newHead == null ? head : newHead;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna