public class PalindromeLinkedList {

  // 234. Palindrome Linked List
  // 86 / 93 testcases passed

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

  public boolean isPalindrome(ListNode head) {

    ListNode aux = head;
    ListNode middleNode = middleNode(head);
    ListNode reverse = reverseList(middleNode.next);
    if (head == null || head.next == null) {
      return true;
    }

    while (reverse != null) {
      if (aux.val != reverse.val) {
        return false;
      }
      aux = aux.next;
      reverse = reverse.next;
    }
    return true;

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
