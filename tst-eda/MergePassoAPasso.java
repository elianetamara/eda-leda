import java.util.Arrays;
import java.util.Scanner;

class MergePassoAPasso {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numeros = transformaLista(sc.nextLine().split(" "));
    mergeSort(numeros, 0, numeros.length-1);
  }
    
  public static void mergeSort(int[] numeros, int left, int right) {
		
		if (left < right) {

      printArray(numeros, left, right);
			int middle = (left + right) / 2;
			mergeSort(numeros, left, middle);
			mergeSort(numeros, middle + 1, right);
	
			merge(numeros, left, middle, right);

		}else{
      printArray(numeros, left, right);
    }
		
	}
	
	public static void merge(int[] numeros, int left, int middle, int right) {

		int[] helper = new int[numeros.length];
		for (int i = left; i <= right; i++) {
			helper[i] = numeros[i];
		}
		
		
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while (i <= middle && j <= right) {
			
			if (helper[i] < helper[j]) {
				numeros[k] = helper[i];
				i++;
			} else {
				numeros[k] = helper[j];
				j++;
			}
			k++;	
			
		}
		
		while (i <= middle) {
			numeros[k] = helper[i];
			i++;
			k++;
		}
		
		while (j <= right) {
			numeros[k] = helper[j];
			j++;
			k++;
		}

    printArray(numeros, left, right);

	}

  public static void printArray(int[] numeros, int left, int right){
    System.out.println(Arrays.toString(Arrays.copyOfRange(numeros, left, right+1)));
  }

  public static int[] transformaLista(String[] lista){
    int[] retorno = new int[lista.length];
    for (int i = 0; i < retorno.length; i++) {
      retorno[i] = Integer.parseInt(lista[i]);
    }
    return retorno;
  }
  
}
