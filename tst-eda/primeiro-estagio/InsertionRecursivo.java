import java.util.Arrays;
import java.util.Scanner;

class InsertionRecursivo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    insertionSortRecursivo(numeros, 1, numeros.length-1);
    System.out.println(Arrays.toString(numeros));

  }

  private static void insertionSortRecursivo(int[] numeros, int i, int n) {
    int j = i;
    while (j > 0 && numeros[j] < numeros[j-1]) {
      int aux = numeros[j];
      numeros[j] = numeros[j - 1];
      numeros[j - 1] = aux;
      j -= 1;
    }
    if (i + 1 <= n) {
      System.out.println(Arrays.toString(numeros));
      insertionSortRecursivo(numeros, i + 1, n);
  }
    
  }

  public static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }
}
