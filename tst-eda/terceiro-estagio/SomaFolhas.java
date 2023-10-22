import java.util.Scanner;

// success: ......

class SomaFolhas {

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

    public Integer sumLeafs() {
      return sumLeafs(this.root, 0);
    }

    private Integer sumLeafs(Node node, int i) {
      if (node.isLeaf())
        i += node.value;

      else {
        if (node.hasOnlyLeftChild()) {
          i += sumLeafs(node.left, 0);
        } else if (node.hasOnlyRightChild()) {
          i += sumLeafs(node.right, 0);
        } else {
          i += sumLeafs(node.left, 0) + sumLeafs(node.right, 0);
        }
      }

      return i;
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

    System.out.println(bst.sumLeafs());
  }

}
