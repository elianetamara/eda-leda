package sorting;

// 2529 - 166 / 166 testcases passed

public class CountPosNeg {

  public int maximumCount(int[] nums) {
    int out;
    if(verifyList(nums)){
      out = nums.length;
    }else{
      int idxNegative = findLastNegative(nums, 0, nums.length-1);
      int idxPositive = findFirstPositive(nums, 0, nums.length-1);
      if(idxNegative == -1 && idxPositive == -1){
        out = 0;
      }else{
        if(idxNegative == -1) out = nums.length - idxPositive;
        else if(idxPositive == -1) out = idxNegative + 1;
        else out = Math.max(idxNegative + 1, nums.length - idxPositive);
      }
    }
    return out;
  }

  private int findLastNegative(int[] nums, int left, int right){
    int idxNegative = -1;

    if(left < right){
      int m = (left+right)/2;

      if(nums[m] < 0 && nums[m+1] >= 0){
        idxNegative = m;

      }else if(nums[m] < 0 && nums[m+1] < 0){
        idxNegative = findLastNegative(nums, m, right);
      }else if(nums[m] >= 0){
        idxNegative = findLastNegative(nums, left, m);
      }
    }

    return idxNegative;
  }

  private int findFirstPositive(int[] nums, int left, int right){
    int idxPositive = -1;

    if(left < right){
      int m = (left+right)/2;

      if(nums[m] > 0 && nums[m-1] > 0){
        idxPositive = findFirstPositive(nums, left, m);
      }else if(nums[m] < 0 || nums[m] == 0){
        idxPositive = findFirstPositive(nums, m+1, right);
      }else if(nums[m] > 0){
        idxPositive = m;
      }
    }

    return idxPositive;
  }

  private int firstPositive(int[] nums, int left, int right){
    int idxNegative = findLastNegative(nums, left, right);
    int idxPositive = -1;

    if(idxNegative < nums.length-1 && nums[idxNegative +1] > 0){
      idxPositive = idxNegative+1;
    }
    return idxPositive;
  }

  private boolean verifyList(int[] nums){
    return nums[0] > 0 || nums[nums.length-1] < 0 ? true : false;
  }

  public static void main(String[] args) {
    CountPosNeg m = new CountPosNeg();
    //int[] n = new int[]{-1563,-236,-114,-55,427,447,687,752,1021,1636};
    int[] n = new int[]{-2,-1,-1,0,0,0};
    System.out.println(m.maximumCount(n));
    
  }
  
}
