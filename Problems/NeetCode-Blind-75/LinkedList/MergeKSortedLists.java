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

class MergeKSortedLists {
  // Using min heap - compare one by one
  public ListNode mergekLists(ListNode[] lists) {

    ListNode head = new ListNode(0);
    Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

    for (ListNode headNode : lists) {
      if (headNode != null) {
        minHeap.add(headNode);
      }
    }

    ListNode curr = head;
    while (minHeap.size() > 0) {
      ListNode min = minHeap.poll();
      if (min.next != null) {
        minHeap.add(min.next);
      }
      curr.next = min;
      curr = curr.next;
    }

    return head.next;

  }

  // merge one by one
  public ListNode mergeKLists(ListNode[] lists) {
    int k = lists.length;
    int interval = 1;
    while (interval < k) {
      for (int i = 0; i + interval < k; i += interval * 2) {
        lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
      }
      interval = interval * 2;
    }
    return lists.length == 0 ? null : lists[0];
  }

  private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
    ListNode curr1 = head1, curr2 = head2, head = new ListNode(0), curr = head;
    while (curr1 != null && curr2 != null) {
      if (curr1.val < curr2.val) {
        curr.next = curr1;
        curr1 = curr1.next;
      } else {
        curr.next = curr2;
        curr2 = curr2.next;
      }
      curr = curr.next;
    }
    while (curr1 != null) {
      curr.next = curr1;
      curr1 = curr1.next;
      curr = curr.next;
    }
    while (curr2 != null) {
      curr.next = curr2;
      curr2 = curr2.next;
      curr = curr.next;
    }
    return head.next;
  }
}