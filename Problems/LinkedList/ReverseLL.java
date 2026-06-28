
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseLL {

  // using stack
  // public ListNode reverseList(ListNode head) {
  // Stack<Integer> valueStack = new Stack<>();
  // while (head != null) {
  // valueStack.push(head.val);
  // head = head.next;
  // }

  // ListNode reversedList = new ListNode(Integer.MIN_VALUE);
  // ListNode ptr = reversedList;

  // while(!valueStack.isEmpty()) {
  // ptr.next = new ListNode(valueStack.pop());
  // ptr = ptr.next;
  // }

  // return reversedList.next;
  // }

  // optimal solution
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }

    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      // 1. get the next node of curr
      ListNode next = curr.next;

      // 2. point prev node as current node's next node
      curr.next = prev;

      // 3. assign curr to prev
      prev = curr;

      // 4. assign next to curr
      curr = next;
    }
    head = prev;
    return head;
  }
}