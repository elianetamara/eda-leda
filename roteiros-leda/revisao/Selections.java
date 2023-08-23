import java.util.Arrays;

public class Selections<T extends Comparable<T>>{

  // ordenando de forma decrescente recursivo/100% recursivo/ normal

  // 100% recursivo
  public void sortRecursivo(T[] array, int leftIndex, int rightIndex) {
    boolean checkParameters = array.length > 0 && rightIndex <= array.length-1 && leftIndex >= 0;
    if(checkParameters){
      if(leftIndex < rightIndex){
        int smallestIndex = findSmallest(array, leftIndex, rightIndex, leftIndex);
        T aux = array[smallestIndex];
        array[smallestIndex] = array[leftIndex];
        array[leftIndex] = aux;			
        sortRecursivo(array, leftIndex+1, rightIndex);
      }
    }
  }

  private int findSmallest(T[] array, int leftIndex, int rightIndex, int smallest){
    int smallestIndex;
    if(leftIndex < rightIndex){
      if(array[smallest].compareTo(array[leftIndex+1]) > 0){
          smallest = leftIndex+1;
      }
      smallestIndex = findSmallest(array, leftIndex+1, rightIndex, smallest);
    }else{
      smallestIndex = smallest;
    }
    return smallestIndex;
  }

  // normal
  public void sortIterativo(T[] array, int leftIndex, int rightIndex) {
    boolean checkParameters = array.length > 0 && rightIndex <= array.length-1 && leftIndex >= 0;
    if(checkParameters){
      for (int i = leftIndex; i <= rightIndex; i++) {
        int smallestIndex = findSmallest(array, i, rightIndex);
        T aux = array[smallestIndex];
        array[smallestIndex] = array[i];
        array[i] = aux;
      }
    }
  }

  private int findSmallest(T[] array, int i, int rightIndex){
    int smallest = i;
    for (int j = i+1; j <= rightIndex; j++) {
      if(array[j].compareTo(array[smallest]) < 0){
        smallest = j;
      }
    }
    return smallest;
  }

  // 1/2 recursivo
  public static void selectionSortRecursivo(int[] array, int i, int n) {
      if (array.length > 0) {
        int menor_index = i;
        for (int j = menor_index + 1; j <= n; j++) {
          if (array[j] < array[menor_index]) {
            menor_index = j;
          }
        }
        int aux = array[menor_index];
        array[menor_index] = array[i];
        array[i] = aux;
        if (i + 1 <= n) {
          System.out.println(Arrays.toString(array));
          selectionSortRecursivo(array, i + 1, n);
        }
      }
    }

  public static void main(String[] args) {
    int[] numeros = new int[]{4, 9, 7, 2, 8};
    selectionDecRecursivo(numeros, 0, numeros.length-1);
    System.out.println(Arrays.toString(numeros));
  }

  public static void selectionDecRecursivo(int[] array, int i, int n) {
      if (array.length > 0) {
        int menor_index = n;
        for (int j = menor_index - 1; j >= i; j--) {
          if (array[j] < array[menor_index]) {
            menor_index = j;
          }
        }
        int aux = array[menor_index];
        array[menor_index] = array[i];
        array[i] = aux;
        if (n >= i) {
          selectionSortRecursivo(array, i, n-1);
        }
      }
    }

  private static void selectionDecIterativo(int[] numeros, int i, int n) {
      for (int j = n; j >= i; j--) {   
        int menor = j;
        for (int k = j - 1; k >= i; k--) {
          if (numeros[k] < numeros[menor]) {
            menor = k;
          }
        }
        swap(numeros, menor, j);
      }
  }

  private static void swap(int[] numeros, int menor_index, int j){
    int aux = numeros[menor_index];
    numeros[menor_index] = numeros[j];
    numeros[j] = aux;
  }

}