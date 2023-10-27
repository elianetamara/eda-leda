import java.util.Scanner;

class TrocaVizinhosLL {

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

    public Node get(int index) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException();

      Node aux = this.head;

      for (int i = 0; i < index; i++)
        aux = aux.next;

      return aux;
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

    public void trocaVizinhos(int x) {
      Node node1 = get(x);
      Node node2 = get(x + 1);
      if (x != 0) {
        node1.next = node2.next;
        node2.prev = node1.prev;
        node2.prev.next = node2;
        node2.next = node1;
        node1.prev = node2;
      }else{
        node1.next = node2.next;
        this.head = node2;
        node2.next = node1;
        node1.prev = node2;
      }
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

    list.trocaVizinhos(x);
    System.out.println(list.toString());
  }

}
