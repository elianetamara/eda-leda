import java.util.Scanner;

class MelhorPivot {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    int[] candidatos = transformaLista(sc.nextLine().split(" "));
    System.out.println(melhorPivot(numeros, candidatos));
  }
    

  private static int melhorPivot(int[] numeros, int[] candidatos) {
    int pivot_i = findPivot(numeros, candidatos[0]);
    int delta_i = delta(numeros, pivot_i);
    int pivot_j = findPivot(numeros, candidatos[1]);
    int delta_j = delta(numeros, pivot_j);
    if(delta_i <= delta_j){
      return candidatos[0];
    }else {
      return candidatos[1];
    }
    
  }

  private static int delta(int[] numeros, int num){
    int menores = findMenores(numeros, num);
    int maiores = numeros.length - 1 - menores;
    int retorno = maiores > menores ? maiores-menores : menores-maiores;
    return Math.abs(retorno);
  }

  private static int findPivot(int[] numeros, int num){
    int retorno = -1;
    for (int k = 0; k < numeros.length; k++) {
      if(k == num){
        retorno = numeros[k];
        break;
      }
    }
    return retorno;
  }

  private static int findMenores(int[] numeros, int num){
    int retorno = 0;
    for (int i = 0; i < numeros.length; i++) {
      if(numeros[i] < num){
        retorno++;
      }
    }
    return retorno;
  }

  private static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }
  
}
