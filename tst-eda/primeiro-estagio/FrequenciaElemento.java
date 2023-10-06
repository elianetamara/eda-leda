import java.util.Scanner;

class FrequenciaElemento {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int x = Integer.parseInt(sc.nextLine());
    String[] y = sc.nextLine().split(" ");
    int count = 0;

    for (int i = 0; i < y.length; i++) {
      count = Integer.parseInt(y[i]) == x ? count+1 : count;
    }
    System.out.println(count);
  }
  
}
