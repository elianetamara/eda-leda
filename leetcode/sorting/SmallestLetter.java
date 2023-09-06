package sorting;

// 744 - 167/167 tests passed

public class SmallestLetter {

  public char nextGreatestLetter(char[] letters, char target) {
    return findLetter(letters, target, 0, letters.length-1);
  }

  private char findLetter(char[] letters, char target, int left, int right){
    char out = letters[0];

    if(left <= right){
      int m = (left+right)/2;

      if( m > 0 && letters[m] > target && letters[m-1] > target){
        out = findLetter(letters, target, left, m);
      }else if(letters[m] == target || letters[m] < target){
        out = findLetter(letters, target, m+1, right);
      }else if(letters[m] > target){
        out = letters[m];
      }
    }

    return out;
  }

}
