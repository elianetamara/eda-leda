import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    inserePrimeiro(numeros);
    System.out.println(Arrays.toString(numeros));

  }

  public static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }

  public static void inserePrimeiro(int[] numeros){
    for (int i = 1; i < numeros.length; i++) { 
      int j = i;
      while (j > 0 && numeros[j] < numeros[j-1]) {
        int aux = numeros[j];
        numeros[j] = numeros[j - 1];
        numeros[j - 1] = aux;
        j -= 1;
      }
    
    }	
  }
}
