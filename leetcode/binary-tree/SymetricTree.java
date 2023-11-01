public class SymetricTree {

  // 101. Symmetric Tree

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

  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;

    return symetric(root.left, root.right);
  }

  private boolean symetric(TreeNode left, TreeNode right) {
    if(left == null && right == null) return true;
    if(left == null || right == null || left.val != right.val) return false;
    return symetric(left.left, right.right) && symetric(left.right, right.left);
  }
  
}
