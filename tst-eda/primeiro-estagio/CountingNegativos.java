import java.util.Arrays;
import java.util.Scanner;

class CountingNegativos {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    int k = Integer.parseInt(sc.nextLine());
    int neg = Integer.parseInt(sc.nextLine());
    countingSort(numeros, k, neg);
  }

  private static void countingSort(int[] numeros, int k, int neg) {
    int[] c = new int[k - neg + 1];
    populaC(numeros, c, neg);
    cumulativa(c);
    int[] b = new int[numeros.length];
    ordenacao(b, numeros, c, neg);
  }    

  private static void populaC(int[] numeros, int[] c, int neg) {
    for (int i = 0; i < numeros.length; i++) {
      c[numeros[i] - neg] += 1;
      printArray(c);
    }
  }

  private static void cumulativa(int[] c){
    for (int i = 1; i < c.length; i++) {
      c[i] += c[i-1];
    }
    System.out.print("Cumulativa do vetor de contagem - ");
    printArray(c);
  }

  private static void ordenacao(int[] b, int[] a, int[]c, int neg){
    for (int i = a.length-1; i >= 0; i--) {
      b[c[a[i]-neg]-1] = a[i];
      c[a[i]-neg] -= 1;
    }
    printArray(c);
    printArray(b);
  }

  private static void printArray(int[] numeros){
    System.out.println(Arrays.toString(numeros));
  }

  public static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }

  
}
