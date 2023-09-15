import java.util.Scanner;

class EstatisticaOrdem {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    System.out.println(estatistica(numeros));
  }


  private static int estatistica(int[] numeros) {
    int pivot = numeros[0];
    int idx_pivot = 0;

    for (int j = 1; j <= numeros.length-1; j++) {
      if(numeros[j] <= pivot){
        idx_pivot += 1;
        swap(numeros, j, idx_pivot);
      }
    }
    swap(numeros, 0, idx_pivot);
    return idx_pivot+1;
  }

  private static void swap(int[] numeros, int idx_pivot, int j){
    int aux = numeros[idx_pivot];
    numeros[idx_pivot] = numeros[j];
    numeros[j] = aux;
  }

  private static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }
  
}
