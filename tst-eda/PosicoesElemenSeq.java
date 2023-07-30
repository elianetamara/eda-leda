import java.util.Scanner;

class PosicoesElemenSeq {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = Integer.parseInt(sc.nextLine());
    String[] y = sc.nextLine().split(" ");
    String out = "";

    for (int i = 0; i < y.length; i++) {
      out = Integer.parseInt(y[i]) == x ? out += i + " " : out;
    }
    out = out.equals("") ? "-1" : out;
    System.out.println(out.trim());
  }
}
