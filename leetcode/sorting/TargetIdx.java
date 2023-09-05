package sorting;

// 2089 - 107 / 216  testcases passed

import java.util.ArrayList;
import java.util.List;

public class TargetIdx {

  public List<Integer> targetIndices(int[] nums, int target) {
    List<Integer> num = tranferList(nums);
    quickSort(num, 0, num.size() - 1);

    List<Integer> idx = binarySearch(num, target);
    return idx;
  }

  private List<Integer> binarySearch(List<Integer> nums, int target) {
    List<Integer> out = new ArrayList<Integer>();

    for (int i = 0; i < nums.size(); i++) {
      if (nums.get(i) == target) {
        out.add(i);
      }
    }
    return out;
  }

  private void quickSort(List<Integer> nums, int left, int right) {
    if (left < right) {
      int idx_pivot = partition(nums, left, right);
      quickSort(nums, left, idx_pivot - 1);
      quickSort(nums, idx_pivot + 1, right);
    }

  }

  private static void swap(List<Integer> numeros, int idx_pivot, int j) {
    Integer aux = numeros.get(idx_pivot);
    numeros.set(idx_pivot, numeros.get(j));
    numeros.set(j, aux);
  }

  private int partition(List<Integer> array, int leftIndex, int rightIndex) {
    int idxPivot = getPivotIdx(array, leftIndex, rightIndex);

    swap(array, leftIndex, idxPivot);
    Integer pivot = array.get(leftIndex);
    int i = leftIndex;

    for (int j = i + 1; j <= rightIndex; j++) {
      if (array.get(j).compareTo(pivot) <= 0) {
        swap(array, ++i, j);
      }
    }
    swap(array, leftIndex, i);
    return i;
  }

  private int getPivotIdx(List<Integer> array, int leftIndex, int rightIndex) {
    int out = rightIndex;
    int middle = (leftIndex + rightIndex) / 2;
    List<Integer> pivots = fillPivotsList(array, leftIndex, rightIndex);

    if (pivots.get(1).compareTo(array.get(leftIndex)) == 0) {
      out = leftIndex;
    }

    if (pivots.get(1).compareTo(array.get(middle)) == 0) {
      out = middle;
    }
    return out;

  }

  private List<Integer> fillPivotsList(List<Integer> array, int leftIndex, int rightIndex) {
    List<Integer> pivots = new ArrayList<Integer>();
    int middle = (leftIndex + rightIndex) / 2;
    pivots.add(0, array.get(leftIndex));
    pivots.add(1, array.get(middle));
    pivots.add(2, array.get(rightIndex));
    insertionSort(array, leftIndex, rightIndex);
    return pivots;
  }

  private void insertionSort(List<Integer> array, int leftIndex, int rightIndex) {
    for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
      int j = i;
      while (j > 0 && (array.get(j).compareTo(array.get(j - 1)) < 0)) {
        swap(array, j, j - 1);
        j -= 1;
      }

    }
  }

  private static List<Integer> tranferList(int[] nums) {
    List<Integer> out = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      out.add(nums[i]);
    }
    return out;
  }

}
