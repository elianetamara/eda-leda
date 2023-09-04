package sorting;
// 2089 - 107 / 216  testcases passed

import java.util.ArrayList;
import java.util.List;

public class TargetIdx{

  public List<Integer> targetIndices(int[] nums, int target) {
    List<Integer> num = tranferList(nums);
    quickSort(num, 0, num.size());

    List<Integer> idx = binarySearch(num, target);
    return idx;
  }

  private List<Integer> binarySearch(List<Integer> nums, int target){
    List<Integer> out = new ArrayList<Integer>();

    for (int i = 0; i < nums.size(); i++) {
      if(nums.get(i) == target){
        out.add(i);
      }
    }
    return out;
  }

  private void quickSort(List<Integer> nums, int left, int right){
    if(left < right){
      int idx_pivot = partition(nums, left, right);
      quickSort(nums, left, idx_pivot-1);
      quickSort(nums, idx_pivot+1, right);
    }

  }

  private static int partition(List<Integer> nums, int left, int right){
    int pivot = nums.get(left);
    int idx_pivot = left;
    
    for (int i = left+1; i < right; i++) {
      if(nums.get(i) <= pivot){
        idx_pivot += 1;
        swap(nums, i, idx_pivot);
      }
    }
    swap(nums, left, idx_pivot);
    return idx_pivot;
    }

    private static void swap(List<Integer> numeros, int idx_pivot, int j){
      Integer aux = numeros.get(idx_pivot);
      numeros.set(idx_pivot, numeros.get(j));
      numeros.set(j, aux);
    }

    private static List<Integer> tranferList(int[] nums){
      List<Integer> out = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; i++) {
        out.add(nums[i]);
      }
      return out;
    }

  }
    