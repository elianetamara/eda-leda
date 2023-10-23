import java.util.Scanner;

// success: .....

class MaxHeap {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] y = sc.nextLine().split(" ");

    int[] nums = new int[y.length];

    for (int i = 0; i < y.length; i++) {
      nums[i] = Integer.parseInt(y[i]);
    }
    System.out.println(isHeap(nums));
  }

  public static boolean isHeap(int[] heap) {
    int root = heap[0];
    if (heap[left(0)] < root && heap[right(0)] < root) {
      return true;
    } else {
      return false;
    }
  }

  public static int left(int i) {
    return 2 * i + 1;
  }

  public static int right(int i) {
    return (i + 1) * 2;
  }

}
