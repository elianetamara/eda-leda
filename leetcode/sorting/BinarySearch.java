package sorting;

// 349 - 47/47 tests passed

public class BinarySearch {

  public int search(int[] nums, int target) {
    int idx = binarySearch(nums, 0, nums.length-1, target);
    return idx;     
  }

  private int binarySearch(int[] nums, int left, int right, int target){
    int idx = -1;

    if(left <= right){
      int m = (left+right)/2;

      if(nums[m] == target){
        idx = m;
      }else if(nums[m] > target){
        idx = binarySearch(nums, left, m-1, target);
      }else if(nums[m] < target){
        idx = binarySearch(nums, m+1, right, target);
      }
    }
    return idx;
  }
  
}
