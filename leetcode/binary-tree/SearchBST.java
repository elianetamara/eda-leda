public class SearchBST {

  // 700. Search in a Binary Search Tree

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

  public TreeNode searchBST(TreeNode root, int val) {
    if(root != null){
      if(root.val == val) return root;
      else if(root.val > val) return searchBST(root.left, val);
      else if (root.val < val) return searchBST(root.right, val);
    }
    return null;  
  }
  
}
