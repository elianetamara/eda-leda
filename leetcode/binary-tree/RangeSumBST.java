import java.util.ArrayList;

// 938. Range Sum of BST

public class RangeSumBST {

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

  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root != null) {
      inOrder(root);
      return range(list, low, high);
    }
    return 0;

  }

  ArrayList<Integer> list = new ArrayList<>();

  private void inOrder(TreeNode node) {
    if (node != null) {
      inOrder(node.left);
      this.list.add(node.val);
      inOrder(node.right);
    }
  }

  private int range(ArrayList<Integer> list, int low, int high) {
    int sum = 0;
    for (Integer integer : list) {
      if(inRange(low, high, integer)){
        sum += integer;
      }
    }    
    return sum;
  }

  private boolean inRange(int low, int high, int num) {
    return num >= low && num <= high;
  }

}
