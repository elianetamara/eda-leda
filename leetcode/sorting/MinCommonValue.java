package sorting;

// 2540 - 40/40 tests passed

public class MinCommonValue {
  public int getCommon(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int[] maior;
    int[] menor;
    if(nums1.length != nums2.length){
      maior = nums1.length > nums2.length ? nums1 : nums2;
      menor = nums1.length < nums2.length ? nums1 : nums2;
    }else{
      maior = nums1;
      menor = nums2;
    }
    int retorno = -1;
    
    while(i < maior.length && j < menor.length){
      if(maior[i] == menor[j]){
        retorno = menor[j];
        break;
      }else if(maior[i] < menor[j]){
        i++;
      }else{
        j++;
      }
      
    }
    return retorno;
  }

}
