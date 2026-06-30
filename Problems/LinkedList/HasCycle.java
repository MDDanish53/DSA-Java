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
public class HasCycle {
    // using hare and tortoise algorithm
    public boolean hasCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;

       while(fast != null && fast.next != null) {

        fast = fast.next.next; // move fast two steps
        slow = slow.next; // move slow one step
        if(fast == slow) {
            return true; // cycle exists
        }
       }
       return false; // cycle does not exists
    }
}