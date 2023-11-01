public class RootEqSumChildren {

  // 2236. Root Equals Sum of Children

  public class TreeNode {
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

  public boolean checkTree(TreeNode root) {
    if (root != null) {
      int sumChildren = sumChildren(root.right, root.left);
      if (sumChildren == root.val)
        return true;
    }
    return false;

  }

  private int sumChildren(TreeNode right, TreeNode left) {
    return right.val + left.val;
  }

}
