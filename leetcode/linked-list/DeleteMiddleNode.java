public class DeleteMiddleNode {

  // 2095. Delete the Middle Node of a Linked List
  // 66 / 70 testcases passed

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

  public ListNode deleteMiddle(ListNode head) {
    ListNode middle;
    if (head == null || head.next == null) {
      middle = null;
    } else {
      middle = middleNode(head);
      middle.next = middle.next.next;
    }
    return head;

  }

  public ListNode middleNode(ListNode head) {
    ListNode aux = head.next.next;
    ListNode out = head;

    while (aux != null && aux.next != null) {
      aux = aux.next.next;
      out = out.next;
    }
    return out;

  }

}
