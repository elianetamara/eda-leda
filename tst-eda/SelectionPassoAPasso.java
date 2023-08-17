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
        int menor_index = j;
        for (int k = j + 1; k <= n; k++) {
          if (numeros[k] < numeros[menor_index]) {
            menor_index = k;
          }
        }
        int aux = numeros[menor_index];
        numeros[menor_index] = numeros[j];
        numeros[j] = aux;
        System.out.println(Arrays.toString(numeros)); 
        if(verificaOrdenacao(numeros))  {break;}
      }
    }

  public static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }
  
  public static boolean verificaOrdenacao(int[] lista){
    for (int i = 0; i < lista.length-1; i++) {
      if(lista[i] > lista[i+1]){
        return false;
      }
    }
    return true;
  }
}
