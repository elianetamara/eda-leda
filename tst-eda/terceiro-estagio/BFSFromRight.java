import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//success: ......

class BFSFromRight {
  
  static class BST {

    private Node root;
    private int size;

    public boolean isEmpty() {
      return this.root == null;
    }

    public void add(int element) {
      this.size += 1;
      if (isEmpty())
        this.root = new Node(element);
      else {

        Node aux = this.root;

        while (aux != null) {

          if (element < aux.value) {
            if (aux.left == null) {
              Node newNode = new Node(element);
              aux.left = newNode;
              newNode.parent = aux;
              return;
            }

            aux = aux.left;
          } else {
            if (aux.right == null) {
              Node newNode = new Node(element);
              aux.right = newNode;
              newNode.parent = aux;
              return;
            }

            aux = aux.right;
          }
        }
      }

    }

    public Node search(int element) {

      Node aux = this.root;

      while (aux != null) {
        if (aux.value == element)
          return aux;
        if (element < aux.value)
          aux = aux.left;
        if (element > aux.value)
          aux = aux.right;
      }

      return null;
    }

    public ArrayList<Integer> bfsFromRight() {
      ArrayList<Integer> list = new ArrayList<Integer>();
      Deque<Node> queue = new LinkedList<Node>();

      if (!isEmpty()) {
        queue.addLast(this.root);
        while (!queue.isEmpty()) {
          Node current = queue.removeFirst();

          list.add(current.value);

          if (current.right != null)
            queue.addLast(current.right);
          if (current.left != null)
            queue.addLast(current.left);

        }
      }
      return list;
    }
  }

  static class Node {

    int value;
    Node left;
    Node right;
    Node parent;

    Node(int v) {
      this.value = v;
    }

    public boolean isLeaf() {
      return this.left == null && this.right == null;
    }

    public boolean hasOnlyLeftChild() {
      return (this.left != null && this.right == null);
    }

    public boolean hasOnlyRightChild() {
      return (this.left == null && this.right != null);
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] y = sc.nextLine().split(" ");
    BST bst = new BST();

    for (int i = 0; i < y.length; i++) {
      bst.add(Integer.parseInt(y[i]));
    }

    ArrayList<Integer> bfs = bst.bfsFromRight();

    System.out.println(formatOut(bfs));
  }

  private static String formatOut(ArrayList<Integer> bfs) {
    String out = "";
    for (Integer integer : bfs) {
      out += integer + " ";
    }
    return out.trim();
  }
}
