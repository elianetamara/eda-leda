import java.util.ArrayList;
import java.util.List;

// 145. Binary Tree Postorder Traversal

public class PostOrderTraversal {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    posOrder(root);
    return this.list;
  }

  ArrayList<Integer> list = new ArrayList<>();

  private void posOrder(TreeNode node) {
    if (node != null) {
      posOrder(node.left);
      posOrder(node.right);
      this.list.add(node.val);
    }
  }

}
