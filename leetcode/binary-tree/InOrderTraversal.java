import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

  // 94. Binary Tree Inorder Traversal

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

  public List<Integer> inorderTraversal(TreeNode root) {
    inOrder(root);
    return this.list;
  }

  ArrayList<Integer> list = new ArrayList<>();

  private void inOrder(TreeNode node) {
    if (node != null) {
      inOrder(node.left);
      this.list.add(node.val);

      inOrder(node.right);
    }
  }

}
