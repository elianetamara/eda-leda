import java.util.Scanner;

class DoisSomam {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] y = sc.nextLine().split(" ");
    int x = Integer.parseInt(sc.nextLine());
    
    System.out.println(soma(y, x));
  }

  public static String soma(String[] y, int x){
    String out = "";

    for (int i = 0; i < y.length; i++) {
      for (int j = i+1; j <= y.length-1; j++) {
        if(Integer.parseInt(y[i]) + Integer.parseInt(y[j]) == x){
           out = y[i] + " " + y[j];
           return out;
        }
       
      }
    }

    return "-1";
  }
}
