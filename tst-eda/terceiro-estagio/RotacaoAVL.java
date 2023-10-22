import java.util.ArrayList;
import java.util.Scanner;

// success: .....

class RotacaoAVL {

  static class AVL {
    private Node root;
    private int size;
    private ArrayList<Integer> preOrder;

    public AVL() {
      this.size = -1;
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

    private void rebalance(Node node) {
      int balance = node.balance();

      if (Math.abs(balance) > 1) {
        callBestRotation(node);
      } else {
        System.out.println("balanceada");
      }
    }

    public void callBestRotation(Node unbalanced) {
      Node x = unbalanced;

      if (x.isLeftPending()) {
        Node y = x.left;

        if (y.left != null) {
          System.out.println("rot_dir(" + x.value + ")");
          rotateRight(x);
          preOrder();
        } else {
          System.out.println("rot_esq(" + y.value + ")");
          rotateLeft(y);
          preOrder();

          System.out.println("rot_dir(" + x.value + ")");
          rotateRight(x);
          preOrder();
        }

      } else {
        Node y = x.right;

        if (y.right != null) {
          System.out.println("rot_esq(" + x.value + ")");
          rotateLeft(x);
          preOrder();
        } else {
          System.out.println("rot_dir(" + y.value + ")");
          rotateRight(y);
          preOrder();
          System.out.println("rot_esq(" + x.value + ")");
          rotateLeft(x);
          preOrder();
        }
      }
    }

    public void rotateRight(Node node) {
      Node newRoot = node.left;
      newRoot.parent = node.parent;

      node.left = newRoot.right;
      newRoot.right = node;

      node.parent = newRoot;

      if (newRoot.parent != null) {
        if (newRoot.parent.left == node)
          newRoot.parent.left = newRoot;
        else
          newRoot.parent.right = newRoot;
      } else
        this.root = newRoot;
    }

    public void rotateLeft(Node node) {
      Node newRoot = node.right;
      newRoot.parent = node.parent;

      node.right = newRoot.left;
      newRoot.left = node;

      node.parent = newRoot;

      if (newRoot.parent != null) {
        if (newRoot.parent.right == node)
          newRoot.parent.right = newRoot;
        else
          newRoot.parent.left = newRoot;
      } else
        this.root = newRoot;
    }

    public void preOrder() {
      this.preOrder = new ArrayList<>();
      preOrder(this.root);
      System.out.println(preOrder.toString());
    }

    private void preOrder(Node node) {
      if (node != null) {
        preOrder.add(node.value);
        preOrder(node.left);
        preOrder(node.right);
      }
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

    public boolean isLeftPending() {
      int left = this.left == null ? -1 : this.left.height();
      int right = this.right == null ? -1 : this.right.height();
      return left - right >= 1;
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] y = sc.nextLine().split(" ");
    AVL avl = new AVL();

    for (int i = 0; i < y.length; i++) {
      avl.recursiveAdd(Integer.parseInt(y[i]));
    }
    avl.rebalance(avl.root);

  }

}
