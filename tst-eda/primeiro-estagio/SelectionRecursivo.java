import java.util.Arrays;
import java.util.Scanner;

class SelectionRecursivo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    selectionSortRecursivo(numeros, 0, numeros.length-1);
    //System.out.println(Arrays.toString(numeros));

  }

  private static void selectionSortRecursivo(int[] numeros, int i, int n) {
    if (numeros.length > 0) {
      int menor_index = i;
      for (int j = menor_index + 1; j <= n; j++) {
        if (numeros[j] < numeros[menor_index]) {
          menor_index = j;
        }
      }
      int aux = numeros[menor_index];
      numeros[menor_index] = numeros[i];
      numeros[i] = aux;
      if (i + 1 <= n) {
        System.out.println(Arrays.toString(numeros));
        selectionSortRecursivo(numeros, i + 1, n);
      }
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
