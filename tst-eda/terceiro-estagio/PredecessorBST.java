import java.util.ArrayList;
import java.util.Scanner;

class PredecessorBST {

  static class BST {

    private Node root;
    private int size;
    private ArrayList<Integer> predPath;

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

    public Node max() {
      if (isEmpty())
        return null;

      Node node = this.root;
      while (node.right != null)
        node = node.right;

      return node;
    }

    private Node max(Node node) {
      if (node.right == null)
        return node;
      else {
        predPath.add(node.right.value);
        return max(node.right);
      }

    }

    public Node predecessor(Node node) {
      predPath = new ArrayList<>();
      if (node == null)
        return null;

      predPath.add(node.value);

      if (node.left != null) {
        predPath.add(node.left.value);
        return max(node.left);
      } else {
        Node aux = node.parent;

        if (aux.value < node.value)
          predPath.add(aux.value);

        while (aux != null && aux.value > node.value) {
          predPath.add(aux.value);
          aux = aux.parent;
        }

        return aux;
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
  }

  static class Node {

    int value;
    Node left;
    Node right;
    Node parent;

    Node(int v) {
      this.value = v;
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] y = sc.nextLine().split(" ");
    int x = Integer.parseInt(sc.nextLine());
    BST bst = new BST();

    for (int i = 0; i < y.length; i++) {
      bst.add(Integer.parseInt(y[i]));
    }

    Node node = bst.search(x);
    bst.predecessor(node);
    System.out.println(bst.predPath.toString());
  }

}