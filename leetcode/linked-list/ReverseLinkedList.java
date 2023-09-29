public class ReverseLinkedList {

  // 206. Reverse Linked List

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

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode aux = head;

    while (aux != null) {
      ListNode next = aux.next;
      aux.next = prev;
      prev = aux;
      aux = next;
    }
    return prev;

  }

}
