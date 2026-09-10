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
        ListNode curr1 = l1;
        ListNode curr2 = l2;  
        ListNode head = new ListNode(0);
        ListNode curr3 = head; 
        int carry=0;
        while(curr1 != null && curr2 != null){
            int dig_sum = 0;
            dig_sum = curr1.val + curr2.val + carry;
            carry = (dig_sum)/10;
            ListNode node = new ListNode((dig_sum)%10);
            curr3.next = node;
            curr3 = node;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1 != null ){
            int dig_sum = 0;
            dig_sum = curr1.val + carry;
            carry = (dig_sum)/10;
            ListNode node = new ListNode((dig_sum)%10);
            curr3.next = node;
            curr3 = node;
            curr1 = curr1.next;
        }
        while(curr2 != null ){
            int dig_sum = 0;
            dig_sum = curr2.val + carry;
            carry = (dig_sum)/10;
            ListNode node = new ListNode((dig_sum)%10);
            curr3.next = node;
            curr3 = node;
            curr2 = curr2.next;
        }
        if (carry > 0){
            ListNode node = new ListNode(carry);
            curr3.next = node;
            curr3 = node;
        }
        return head.next;
    }
}