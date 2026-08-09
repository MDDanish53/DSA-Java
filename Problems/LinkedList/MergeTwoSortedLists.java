
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
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // ArrayList<Integer> nums = new ArrayList<>();
    // while(list1 != null) {
    // nums.add(list1.val);
    // list1 = list1.next;
    // }
    // while(list2 != null) {
    // nums.add(list2.val);
    // list2 = list2.next;
    // }
    // nums.sort(null);
    // if(nums.size() == 0) return null;
    // ListNode sortedList = new ListNode(nums.get(0));
    // ListNode ptr = sortedList;
    // for(int i = 1; i < nums.size(); i++) {
    // ptr.next = new ListNode(nums.get(i));
    // ptr = ptr.next;
    // }
    // return sortedList;
    // }

    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // ListNode ptr1 = list1;
    // ListNode ptr2 = list2;
    // ListNode newPtr = null;
    // ListNode mergedList = null;

    // if(list1 == null && list2 != null) {
    // return list2;
    // }

    // if(list2 == null && list1 != null) {
    // return list1;
    // }

    // while(ptr1 != null && ptr2 != null) {
    // if(ptr1.val < ptr2.val || ptr1.val == ptr2.val) {
    // if(mergedList == null) {
    // mergedList = new ListNode(ptr1.val);
    // newPtr = mergedList;
    // ptr1 = ptr1.next;
    // } else {
    // mergedList.next = new ListNode(ptr1.val);
    // mergedList = mergedList.next;
    // ptr1 = ptr1.next;
    // }
    // } else if(ptr1.val > ptr2.val) {
    // if(mergedList == null) {
    // mergedList = new ListNode(ptr2.val);
    // newPtr = mergedList;
    // ptr2 = ptr2.next;
    // } else {
    // mergedList.next = new ListNode(ptr2.val);
    // mergedList = mergedList.next;
    // ptr2 = ptr2.next;
    // }
    // }
    // }

    // if(ptr1 == null) {
    // while(ptr2 != null) {
    // mergedList.next = new ListNode(ptr2.val);
    // mergedList = mergedList.next;
    // ptr2 = ptr2.next;
    // }
    // }

    // if(ptr2 == null) {
    // while(ptr1 != null) {
    // mergedList.next = new ListNode(ptr1.val);
    // mergedList = mergedList.next;
    // ptr1 = ptr1.next;
    // }
    // }

    // return newPtr;
    // }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode returnNode = new ListNode(Integer.MIN_VALUE);

        ListNode headNode = returnNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                returnNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                returnNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            returnNode = returnNode.next;
        }

        if (list1 == null) {
            returnNode.next = list2;
        } else if (list2 == null) {
            returnNode.next = list1;
        }

        return headNode.next;
    }
}