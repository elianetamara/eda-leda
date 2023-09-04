package sorting;

// 367 /71 tests passed

// ajuste: busca binaria com double (+- R06)

public class PerfectSquare {
  public boolean isPerfectSquare(int num) {
    boolean isPerfectSquare = searchSquare(num, 0, num);
    return isPerfectSquare;
  }

  private boolean searchSquare(int num, int left, int right) {
    boolean hasSquare = false;

    if(left < right){
      int m = (left + right)/2;

      if(m*m == num){
        hasSquare = true;
      }else if (m*m > num){
        hasSquare = searchSquare(num, left, m);
      }else if(m*m < num){
        hasSquare = searchSquare(num, m, right);
      }
    }
    return hasSquare;
  }

  public static void main(String[] args) {
    PerfectSquare p = new PerfectSquare();
    System.out.println(p.isPerfectSquare(16));
  }
}
