import java.util.Scanner;
import java.util.Arrays;

class TrocaVizinhos {
  	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String[] numeros = sc.nextLine().split(" ");
      int limite = numeros.length % 2 != 0 ? numeros.length-1 : numeros.length;
      
      for(int i = 0; i < limite; i+=2){
        String aux = numeros[i];
        numeros[i] = numeros[i+1];
        numeros[i+1] = aux;
      }
      System.out.println(Arrays.toString(numeros));
  }
}
