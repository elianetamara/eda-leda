import java.util.Scanner;

class DownN {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    int n = Integer.parseInt(sc.nextLine().trim());
    downN(numeros, n);
  }

  private static void downN(int[] numeros, int n) {
    selectionSort(numeros, 0, numeros.length-1);
    printArray(numeros, n);
  }

  private static void printArray(int[] numeros, int n){
    String out = "";
    for (int i = 0; i < n; i++) {
      out += numeros[i] + " ";
    }
    System.out.println(out.trim());
  }

  private static void selectionSort(int[] numeros, int i, int n) {
      for (int j = i; j <= n; j++) {   
        int menor = j;
        for (int k = j + 1; k <= n; k++) {
          if (numeros[k] < numeros[menor]) {
            menor = k;
          }
        }
        swap(numeros, menor, j);
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
