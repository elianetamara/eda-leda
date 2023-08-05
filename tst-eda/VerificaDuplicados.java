import java.util.Scanner;

class VerificaDuplicados {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] numeros = sc.nextLine().split(" ");

    System.out.println(verificacao(numeros));
  }

  public static boolean verificacao(String[] numeros){
    for (int i = 0; i < numeros.length; i++) {
      for (int j = i+1; j < numeros.length; j++) {
        if(Integer.valueOf(numeros[i]) == Integer.valueOf(numeros[j])){
          return true;
        }
      }
    }
    return false;
  }
}
