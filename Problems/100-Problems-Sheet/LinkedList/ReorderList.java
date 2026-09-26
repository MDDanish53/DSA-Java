 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class ReorderList {

    // brute force
    // public void reorderList(ListNode head) {
    //     ListNode ptr = head;
    //     List<Integer> nums = new ArrayList<>();
    //     while(ptr != null) {
    //         nums.add(ptr.val);
    //         ptr = ptr.next;
    //     }

    //     boolean turn = true;
    //     int front = 1;
    //     int last = nums.size() - 1;
    //     ptr = head;

    //     for(int i = 1; i < nums.size(); i++) {
    //         if(turn) {
    //             ptr.next = new ListNode(nums.get(last));
    //             last--;
    //             ptr = ptr.next;
    //             turn = false;
    //         } else {
    //             ptr.next = new ListNode(nums.get(front));
    //             front++;
    //             ptr = ptr.next;
    //             turn = true;
    //         }
    //     }

    // }

    // optimized code
    public void reorderList(ListNode head) {

        // base case
        if(head == null || head.next == null) {
            return;
        }

        // find the middle node of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Reverse the half after middle
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while(preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        // start reordering
        p1 = head;
        p2 = preMiddle.next;
        while(p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }

    }
}