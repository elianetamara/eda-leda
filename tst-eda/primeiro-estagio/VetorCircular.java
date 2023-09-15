import java.util.Scanner;

class VetorCircular {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] numeros = sc.nextLine().split(" ");
    int x = Integer.parseInt(sc.nextLine());
    
    String out = "";
    int count = 0;

    for(int i = 0; i < x; i++){
      count = count >= numeros.length ? 0 : count;
      out += numeros[count] + " ";
      count++;
    }

    System.out.println(out.trim());
  }
}
 