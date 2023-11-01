public class SumLeftLeaves {

  // 404. Sum of Left Leaves

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

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
      return 0;
    if (leftLeaf(root))
      return root.left.val + sumOfLeftLeaves(root.right);
    return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

  }

  private boolean leftLeaf(TreeNode node) {
    return node.left != null && node.left.left == null && node.left.right == null;
  }

}
