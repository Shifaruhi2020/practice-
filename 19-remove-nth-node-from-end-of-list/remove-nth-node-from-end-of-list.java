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
//  Link for the solution : https://www.youtube.com/watch?v=6gI8OMoac4Q
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for(int i = 0 ; i < n ; i ++){
            second = second.next;
        }

        while(second.next != null){
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

        return dummy.next;  
    }
}