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
    System.out.println(m.maximumCount(n));
    
  }
  
}
