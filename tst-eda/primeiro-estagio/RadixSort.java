import java.util.Arrays;
import java.util.Scanner;

class RadixSort {

  // erro formatacao
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    int d = Integer.parseInt(sc.nextLine());
    radixSort(numeros, d);
  }

  private static int getMax(int[] numeros) {
    int max = numeros[0];
    for (int i = 1; i < numeros.length; i++){
        if (numeros[i] > max)
          max = numeros[i];
    }
    return max;
  }
  
  public static void radixSort(int[] numeros, int d) {
      int digito = d;
      int n = numeros.length;
      int[] result = new int[n]; 
      int maiorNum = getMax(numeros);
  
      while(maiorNum/digito > 0){
        
        int[] count = new int[10];

        for (int i = 0; i < 10; i++){
          count[i] = 0;
        }
            
        for (int i = 0; i < n; i++){
          count[(numeros[i]/digito)%10] += 1;
        }
  
        for (int i = 1; i < 10; i++){
          count[i] += count[i - 1];
        }
  
        for (int i = n - 1; i >= 0; i--) {
          result[count[ (numeros[i]/digito)%10 ] - 1] = numeros[i];
          count[ (numeros[i]/digito)%10 ]--;
        }
  
        for (int i = 0; i < n; i++) {
          numeros[i] = result[i];
        }
        digito *= 10;
        System.out.println(Arrays.toString(numeros));
      }
  }

  private static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }
}
