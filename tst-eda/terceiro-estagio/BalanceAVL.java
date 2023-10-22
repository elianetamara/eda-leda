import java.util.ArrayList;
import java.util.Scanner;

// success: ......

class BalanceAVL {

  static class AVL {
    private Node root;
    private int size;
    private ArrayList<Integer> preOrder;
    private ArrayList<Integer> balance;

    public AVL() {
      this.size = -1;
      this.preOrder = new ArrayList<>();
      this.balance = new ArrayList<>();
    }

    public boolean isEmpty() {
      return this.root == null;
    }

    public void recursiveAdd(int element) {

      if (isEmpty())
        this.root = new Node(element);
      else {
        Node aux = this.root;
        recursiveAdd(aux, element);
      }
      this.size += 1;

    }

    public void recursiveAdd(Node node, int element) {

      if (element < node.value) {
        if (node.left == null) {
          Node newNode = new Node(element);
          node.left = newNode;
          newNode.parent = node;

          return;
        }
        recursiveAdd(node.left, element);
      } else {
        if (node.right == null) {
          Node newNode = new Node(element);
          node.right = newNode;
          newNode.parent = node;

          return;
        }
        recursiveAdd(node.right, element);
      }
    }

    public void preOrder() {
      preOrder(this.root);
    }

    private void preOrder(Node node) {
      if (node != null) {
        preOrder.add(node.value);
        balance.add(node.balance());
        preOrder(node.left);
        preOrder(node.right);
      }
    }

    public String preOrderBalance() {
      String out = "";
      for (int i = 0; i < preOrder.size(); i++) {
        out += (preOrder.get(i) + "," + balance.get(i) + " ");
      }
      return out.trim();
    }

  }

  static class Node {

    int value;
    int height;
    Node left;
    Node right;
    Node parent;

    Node(int v) {
      this.height = 0;
      this.value = v;
    }

    public int height() {
      if (this.left == null && this.right == null)
        return 0;
      else if (this.left == null) {
        return 1 + this.right.height();
      } else if (this.right == null) {
        return 1 + this.left.height();
      } else {
        return 1 + max(this.left.height(), this.right.height());
      }
    }

    private int max(int height1, int height2) {
      if (height1 >= height2)
        return height1;
      return height2;
    }

    public int balance() {
      int left = this.left == null ? -1 : this.left.height();
      int right = this.right == null ? -1 : this.right.height();
      return left - right;
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] y = sc.nextLine().split(" ");
    AVL avl = new AVL();

    for (int i = 0; i < y.length; i++) {
      avl.recursiveAdd(Integer.parseInt(y[i]));
    }
    avl.preOrder();

    System.out.println(avl.preOrderBalance());

  }

}
