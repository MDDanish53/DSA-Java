
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

class PalindromeLL {
    // using stack
    // public boolean isPalindrome(ListNode head) {
    // Stack<Integer> nums = new Stack<>();
    // ListNode ptr = head;
    // int count = 0;
    // int n = 0;

    // // get the count of nodes in list
    // while(ptr != null) {
    // count++;
    // ptr = ptr.next;
    // }

    // // half the count
    // n = count/2;

    // // insert half list in stack
    // for(int i = 0; i < n; i++) {
    // nums.push(head.val);
    // head = head.next;
    // }

    // // odd length handle, leave the mid node and goto its next node for
    // comparison
    // if(count % 2 != 0) {
    // head = head.next;
    // }

    // // compare the remaining half with the stack values
    // while(head != null && !nums.isEmpty()) {
    // if(head.val == nums.pop()) {
    // head = head.next;
    // continue;
    // } else {
    // return false;
    // }
    // }

    // return true;
    // }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    // optimized approach
    public boolean isPalindrome(ListNode head) {
        // 1. find middle using hare and tortoise algorithm
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }

        // slow will be at the mid of the list
        // reverse the list from slow to the end of the list
        slow = reverseList(slow);
        // point fast again to head
        fast = head;

        // compare both the halves i.e first half of the original list and remaining
        // reversed half of the original list
        while (slow != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }
}