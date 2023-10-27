import java.util.Scanner;

class RemoveIdxLL {

  static class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
      this.head = null;
      this.tail = null;
      this.size = 0;
    }

    public boolean isEmpty() {
      return this.head == null && this.tail == null;
    }

    public void addLast(Integer num) {
      Node newNode = new Node(num);

      if (isEmpty()) {
        this.head = newNode;
        this.tail = head;
      } else {
        this.tail.next = newNode;
        newNode.prev = tail;
        this.tail = newNode;
      }
      this.size += 1;
    }

    public Integer removeFirst() {

      if (isEmpty())
        return null;

      Integer num = this.head.num;

      if (this.head.next == null) {
        this.head = null;
        this.tail = null;
      } else {
        this.head = this.head.next;
        this.head.prev = null;
      }

      size -= 1;
      return num;
    }

    public Integer removeLast() {

      if (isEmpty())
        return null;

      Integer num = this.tail.num;

      if (this.head.next == null) {
        this.head = null;
        this.tail = null;
      } else {
        this.tail = this.tail.prev;
        this.tail.next = null;
      }

      size -= 1;
      return num;
    }

    public Integer remove(int index) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException();

      if (index == 0)
        return removeFirst();
      if (index == size - 1)
        return removeLast();

      Node aux = this.head;
      for (int i = 0; i < index; i++)
        aux = aux.next;

      aux.prev.next = aux.next;
      aux.next.prev = aux.prev;
      size -= 1;
      return aux.num;
    }

    public String toString() {
      Node aux = this.head;
      String out = "";
      while (aux != null) {
        out += aux.num + " ";
        aux = aux.next;
      }
      return out.trim();

    }

  }

  static class Node {

    Integer num;
    Node next;
    Node prev;

    public Node(Integer num) {
      this.num = num;
      this.prev = null;
      this.next = null;
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] y = sc.nextLine().split(" ");
    int x = Integer.parseInt(sc.nextLine());
    LinkedList list = new LinkedList();

    for (int i = 0; i < y.length; i++) {
      list.addLast(Integer.parseInt(y[i]));
    }

    list.remove(x);
    System.out.println(list.toString());
  }
}