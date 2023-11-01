public class MergeBST {

  // 617. Merge Two Binary Trees

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

  public TreeNode mergeTrees(TreeNode n1, TreeNode n2) {

    if (n1 == null && n2 == null)
      return null;

    TreeNode root = new TreeNode();
    if (n1 == null)
      root.val = n2.val;
    else if (n2 == null)
      root.val = n1.val;
    else
      root.val = n1.val + n2.val;

    root.left = mergeTrees(n1 == null ? null : n1.left, n2 == null ? null : n2.left);
    root.right = mergeTrees(n1 == null ? null : n1.right, n2 == null ? null : n2.right);
    
    return root;
  }

}
