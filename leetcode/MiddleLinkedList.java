public class MiddleLinkedList {

  // 876 - Middle of the Linked List

  public class ListNode {
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

  public ListNode middleNode(ListNode head) {
    ListNode aux = head;
    ListNode out = head;

    while (aux != null && aux.next != null) {
      aux = aux.next.next;
      out = out.next;
    }
    return out;

  }

}
