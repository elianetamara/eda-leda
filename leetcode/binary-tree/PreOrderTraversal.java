import java.util.ArrayList;
import java.util.List;

// 144. Binary Tree Preorder Traversal

public class PreOrderTraversal {

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

  public List<Integer> preorderTraversal(TreeNode root) {
    preOrder(root);
    return this.list;
  }

  ArrayList<Integer> list = new ArrayList<>();

  private void preOrder(TreeNode node) {
    if (node != null) {
      this.list.add(node.val);
      preOrder(node.left);
      preOrder(node.right);
    }
  }

}
