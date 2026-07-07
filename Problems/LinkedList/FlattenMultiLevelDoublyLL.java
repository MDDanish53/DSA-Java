// Definition for a Node.
class Node {
  public int val;
  public Node prev;
  public Node next;
  public Node child;
};

class FlattenMultiLevelDoublyLL {
  public Node flatten(Node head) {

    if (head == null) {
      return null;
    }
    Node curr = head;
    while (curr != null) {
      if (curr.child != null) {
        // flatten the child nodes
        Node next = curr.next;
        curr.next = flatten(curr.child);
        curr.next.prev = curr;
        curr.child = null;

        // find tail
        while (curr.next != null) {
          curr = curr.next;
        }

        // attach next with tail
        if (next != null) {
          curr.next = next;
          next.prev = curr;
        }
      }
      curr = curr.next;
    }

    return head;
  }
}