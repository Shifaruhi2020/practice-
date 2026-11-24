/* problem link : https://takeuforward.org/practice/dsa/traversal-in-linked-list

Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/

class Solution {
    public List<Integer> LLTraversal(ListNode head) {
        //your code goes here

        List<Integer> l = new ArrayList<>();

        ListNode tmp = head;

        while(tmp != null){
            l.add(tmp.data);
            tmp = tmp.next;
        }

        return l;
    }
}