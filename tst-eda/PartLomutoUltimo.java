import java.util.Arrays;
import java.util.Scanner;

class PartLomutoUltimo {

  //erro na formatação tst
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    particionaUltimo(numeros, 0, numeros.length-1);
  }
    

  private static void particionaUltimo(int[] numeros, int left, int right) {
    int pivot = numeros[right];
    int idx = left;

    for (int j = left; j < right; j++) {
      if(numeros[j] <= pivot){
        swap(numeros, j, idx);
        idx += 1;
      }
    }
    swap(numeros, right, idx);
  }

  private static void swap(int[] numeros, int idx_pivot, int j){
    int aux = numeros[idx_pivot];
    numeros[idx_pivot] = numeros[j];
    numeros[j] = aux;
    printArray(numeros);
  }

  private static void printArray(int[] numeros){
    System.out.println(Arrays.toString(numeros));
  }

  private static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }
}
