package sorting;

// 977 - memory limit excedeed (counting sort)
// 977 - 10/137 tests passed (insertion sort)

public class SquaresArray {

  public int[] sortedSquares(int[] nums) {
    int[] out = copy(nums);
    squares(out);
    insertionSort(out, 0, out.length-1);
    return out;
  }

  private void squares(int[] nums){
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i]*nums[i];
    }
  }

  private int[] copy(int[] nums){
    int[] out = new int[nums.length];
    for (int i = 0; i < out.length; i++) {
      out[i] = nums[i];
    } return out;
  }

  private void insertionSort(int[] array, int leftIndex, int rightIndex) {
    for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
      int j = i;
      while (j > 0 && array[j] < array[j - 1]) {
        swap(array, j, j - 1);
        j -= 1;
      }

    }
  }

  private static void swap(int[] numeros, int idx_pivot, int j) {
    Integer aux = numeros[idx_pivot];
    numeros[idx_pivot] =  numeros[j];
    numeros[j] = aux;
  }
  
}
