import java.util.Scanner;

class QuickPassoAPasso {
  
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    quickSort(numeros, 0, numeros.length-1);
  }
    

  private static void quickSort(int[] numeros, int left, int right) {
    if(left < right){
      int idx_pivot = particiona(numeros, left, right);
      printArray(numeros);
      quickSort(numeros, left, idx_pivot-1);
      quickSort(numeros, idx_pivot+1, right);
    }
  }


  private static int particiona(int[] numeros, int left, int right) {
    int pivot = numeros[left];
    int idx_pivot = left;

    for (int j = left+1; j <= right; j++) {
      if(numeros[j] <= pivot){
        idx_pivot += 1;
        swap(numeros, j, idx_pivot);
      }
    }
    swap(numeros, left, idx_pivot);
    return idx_pivot;
  }

  private static void swap(int[] numeros, int idx_pivot, int j){
    int aux = numeros[idx_pivot];
    numeros[idx_pivot] = numeros[j];
    numeros[j] = aux;
  }

  private static void printArray(int[] numeros){
    String out = "";
    for (int i = 0; i < numeros.length; i++) {
      out += numeros[i] + " ";
    }
    System.out.println(out.trim());
  }

  private static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }
}
