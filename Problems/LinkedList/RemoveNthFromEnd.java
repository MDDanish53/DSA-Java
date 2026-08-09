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

class RemoveNthFromEnd {
  // Brute force
  // public ListNode removeNthFromEnd(ListNode head, int n) {
  // Stack<Integer> nums = new Stack<>();
  // while (head != null) {
  // nums.push(head.val);
  // head = head.next;
  // }
  // Stack<Integer> newNums = new Stack<>();
  // int count = 1;
  // while (!nums.isEmpty()) {
  // if (count == n) {
  // nums.pop();
  // count++;
  // continue;
  // } else {
  // newNums.push(nums.pop());
  // count++;
  // }
  // }
  // if (newNums.isEmpty()) {
  // return null;
  // }
  // ListNode newHead = new ListNode(newNums.pop());
  // ListNode ptr = newHead;
  // while (!newNums.isEmpty()) {
  // newHead.next = new ListNode(newNums.pop());
  // newHead = newHead.next;
  // }
  // return ptr;
  // }

  // optimal solution
  public ListNode RemoveNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode firstPtr = dummy;
    ListNode secondPtr = dummy;

    for (int i = 0; i < n; i++) {
      secondPtr = secondPtr.next;
    }

    while (secondPtr.next != null) {
      firstPtr = firstPtr.next;
      secondPtr = secondPtr.next;
    }

    firstPtr.next = firstPtr.next.next;

    return dummy.next;
  }
}