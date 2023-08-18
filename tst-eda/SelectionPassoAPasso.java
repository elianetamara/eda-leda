import java.util.Arrays;
import java.util.Scanner;

class SelectionPassoAPasso {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    selectionSort(numeros, 0, numeros.length-1);
  }

  private static void selectionSort(int[] numeros, int i, int n) {
      for (int j = i; j <= n; j++) {   
        boolean troca = false;
        int menor = j;
        for (int k = j + 1; k <= n; k++) {
          if (numeros[k] < numeros[menor]) {
            menor = k;
            troca = true;
          }
        }
        swap(numeros, menor, j);
        if(troca) {System.out.println(Arrays.toString(numeros)); }
      }
    }

  private static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }

  private static void swap(int[] numeros, int menor_index, int j){
    int aux = numeros[menor_index];
    numeros[menor_index] = numeros[j];
    numeros[j] = aux;
  }
  
}
