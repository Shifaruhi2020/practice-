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
// refer solution : https://www.youtube.com/watch?v=xnjwT4sDf8o
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        }  

        ListNode prev = null, cur = slow.next;
        slow.next = null;
        while (cur != null){
        ListNode nxt = cur.next;
        cur.next = prev;
        prev = cur;
        cur = nxt;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second != null ){
        ListNode tmp1 = first.next, tmp2 = second.next;
        first.next = second;
        second.next = tmp1;
        first = tmp1;
        second = tmp2;
        }
    }
}