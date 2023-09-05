package sorting;

// 2529

/*
 * refazer
 *  binary search to find the last negative number index
    binary search to find the first positive number index
    if both are cannot be found, that means only 0 exsits in the array
    if only negative or positive number exists, return the array length
    if both are exsited then negative numbers length = last negative number index + 1, positive numbers length = array length - first positive number index
    compare two length and return the bigger one
 */

public class CountPosNeg {

  public int maximumCount(int[] nums) {
    int[] counts = searchNumbers(nums, 0, nums.length-1);
    int retorno = counts[0] > counts[1] ? counts[0] : counts[1];
    return retorno;
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

  private int firstPositive(int[] nums, int left, int right){
    int idxNegative = findLastNegative(nums, left, right);
    int idxPositive = -1;

    if(idxNegative < nums.length-1 && nums[idxNegative +1] > 0){
      idxPositive = idxNegative+1;
    }
  }

  private boolean verifyList(int[] nums){
    return nums[0] > 0 || nums[nums.length-1] < 0 ? true : false;
  }

  private int[] searchNumbers(int[] nums, int left, int right){
    int[] counts = new int[2];

    if(left < right){
      int m = (left+right)/2;

      if(nums[m] > 0){
        counts[0] += 1;
      }else{
        counts[1] += 1;
      }
      searchNumbers(nums, left, m-1);
      searchNumbers(nums, m+1, right);
    }
    return counts;
  }

  public static void main(String[] args) {
    CountPosNeg m = new CountPosNeg();
    int[] n = new int[]{-2,-1,-1,1,2,3};
    //int[] n1 = new int[]{-3,-2,-1,0,0,1,2};
    int[] n1 = new int[]{-3,-2,-1,0,0,1,2};
    int[] n2 = new int[]{5,20,66,1314};
    //System.out.println(m.findLastNegative(n, 0, n.length-1));
    System.out.println(m.findLastNegative(n1, 0, n1.length-1));
    //System.out.println(m.findLastNegative(n2, 0, n2.length-1));
    System.out.println(m.maximumCount(n));
    
  }
  
}
