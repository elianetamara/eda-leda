public class IntersecLinkedList {

  // 160. Intersection of Two Linked Lists

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

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode out = null;
    if (headA != null || headB != null) {

      ListNode auxA = headA;
      ListNode auxB = headB;

      while (auxA != auxB) {
        auxA = auxA == null ? headB : auxA.next;
        auxB = auxB == null ? headA : auxB.next;
      }

      out = auxA;
    }

    return out;

  }

}
