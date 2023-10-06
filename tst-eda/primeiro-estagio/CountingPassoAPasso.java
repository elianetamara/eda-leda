import java.util.Scanner;

class CountingPassoAPasso {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    int k = Integer.parseInt(sc.nextLine());
    countingSort(numeros, k);
  }

  private static void countingSort(int[] numeros, int k) {
    int[] c = new int[k+1];
    populaC(numeros, c);
    cumulativa(c);
    int[] b = new int[numeros.length];
    ordenacao(b, numeros, c);
  }    
  

  private static void populaC(int[] numeros, int[] c) {
    for (int i = 0; i < numeros.length; i++) {
      c[numeros[i]] += 1; 
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

  private static void ordenacao(int[] b, int[] a, int[]c){
    for (int i = a.length-1; i >= 0; i--) {
      b[c[a[i]]-1] = a[i];
      c[a[i]] -= 1;
    }
    printArray(c);
    printArray(b);
  }

  private static void printArray(int[] numeros){
    String out = "";
    for (int i = 0; i < numeros.length; i++) {
      out += numeros[i] + " ";
    }
    System.out.println(out.trim());
  }

  public static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }

}
