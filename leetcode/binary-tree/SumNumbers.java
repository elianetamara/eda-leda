public class SumNumbers {

  // 129. Sum Root to Leaf Numbers

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

  public int sumNumbers(TreeNode root) {
    return sum(root, 0);
  }

  private int sum(TreeNode root, int numNodes) {
    int result = 0;
    if(root == null) return 0;
    numNodes = root.val + ( 10 * numNodes);

    if(root.left == null && root.right == null){
        result += numNodes;
    }
    result += sum(root.left, numNodes);
    result += sum(root.right, numNodes);

    return result;
  }

}
