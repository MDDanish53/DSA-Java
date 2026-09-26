
// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class IntersectionOfTwoLists {

  public int getListLength(ListNode head) {
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lengthA = getListLength(headA);
    int lengthB = getListLength(headB);

    while (lengthA > lengthB) {
      lengthA--;
      headA = headA.next;
    }

    while (lengthB > lengthA) {
      lengthB--;
      headB = headB.next;
    }

    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }

    return headA;
  }
}