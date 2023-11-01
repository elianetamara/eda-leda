import java.util.ArrayList;

// 783. Minimum Distance Between BST Nodes - 44 / 49 testcases passed

public class MinDistBST {

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

  public int minDiffInBST(TreeNode root) {
    inOrder(root);
    return minArray(list, list.get(0), 0);

  }

  private int minArray(ArrayList<Integer> array, int min, int idx) {
    if (idx >= array.size()-1)
      return min;
    if ((array.get(idx+1)-array.get(idx)) < min) {
      min = (array.get(idx+1)-array.get(idx));
    }
    idx++;
    min = minArray(array, min, idx);

    return min;
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