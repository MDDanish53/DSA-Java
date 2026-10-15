
// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class MergeTwoSortedLists {

  // recursive approach
  public ListNode mergeTwolists(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;

    if (list1.val < list2.val) {
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
    }
  }

  // iterative approach
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode returnNode = new ListNode(Integer.MIN_VALUE);

    ListNode ptr = returnNode;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        ptr.next = list1;
        list1 = list1.next;
      } else {
        ptr.next = list2;
        list2 = list2.next;
      }
      ptr = ptr.next;
    }

    if (list1 == null) {
      ptr.next = list2;
    }
    if (list2 == null) {
      ptr.next = list1;
    }

    return returnNode.next;
  }
}