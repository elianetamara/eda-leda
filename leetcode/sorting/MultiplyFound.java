package sorting;

// 2154 - 81 / 81 testcases passed (com insertion sort)
// 2154 - 62 / 81 testcases passed (erro ordenação - escolha de pivot)

public class MultiplyFound {

  public int findFinalValue(int[] nums, int original) {
    this.insertionSort(nums, 0, nums.length-1);

    if(!searchValue(nums, original, 0, nums.length-1)){
      return original;
    }
    original = original*2;

    return findFinalValue(nums, original);
        
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

  private boolean searchValue(int[] nums, int original, int left, int right) {
    boolean isInside = false;

    if (left <= right) {
      int m = (left + right) / 2;

      if (nums[m] == original) {
        isInside = true;
      } else if (nums[m] < original) {
        isInside = searchValue(nums, original, m + 1, right);
      } else if (nums[m] > original) {
        isInside = searchValue(nums, original, left, m-1);
      }
    }

    return isInside;
  }

  public static void main(String[] args) {
    MultiplyFound m = new MultiplyFound();

    int[] l = new int[] { 4, 2 };
    System.out.println(m.findFinalValue(l, 2));
  }

}
