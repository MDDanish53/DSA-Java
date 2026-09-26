
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

// compare one by one (optimized)
class Solution1 {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = new ListNode(0);
    PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
    for (ListNode node : lists) {
      if (node != null) {
        minHeap.add(node);
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
}

// merge one by one (optimized)
class Solution2 {
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

  public ListNode mergeKLists(ListNode[] lists) {
    int k = lists.length;
    int interval = 1;
    while (interval < k) {
      for (int i = 0; i + interval < k; i += interval * 2) {
        lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
      }
      interval = interval * 2;
    }
    return lists.length > 0 ? lists[0] : null;
  }
}