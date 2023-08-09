import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    insereUltimo(numeros);
    System.out.println(Arrays.toString(numeros));

  }

  public static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }

  // verificar
  public static void insereUltimo(int[] numeros){
    for (int i = 1; i < numeros.length; i++) { 
		
      int j = i;
    
      while (j > 0 && numeros[j] < numeros[j-1]) {
        int aux = numeros[j];
        numeros[j] = numeros[j - 1];
        numeros[j - 1] = aux;
        j -= 1;
      }
    
    }	
  }
}