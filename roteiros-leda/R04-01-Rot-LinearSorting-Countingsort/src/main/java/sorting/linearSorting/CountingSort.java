package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		boolean checkParameters = array.length > 0 && rightIndex <= array.length-1 && leftIndex >= 0;
		if(checkParameters){
			Integer[] B = countingSort(array, leftIndex, rightIndex);
			changeArray(B, array, rightIndex, leftIndex);
		}
	}

	private Integer[] countingSort(Integer[] array, int leftIndex, int rightIndex){
		int k = findBigger(array, leftIndex, rightIndex);
		Integer[] C = new Integer[k+1];
		nullToZero(C);

		for (int i = leftIndex; i <= rightIndex; i++) {
			C[array[i]] += 1;	
		}

		for (int i = 1; i < C.length; i++) {
			C[i] += C[i-1];
		}

		Integer[] B = new Integer[rightIndex+1];
		nullToZero(B);

		for (int i = rightIndex; i >= leftIndex; i--) {
			B[C[array[i]]-1] = array[i];
			C[array[i]] -= 1;
		}
		return B;
	}

	private static int findBigger(Integer[] array, int leftIndex, int rightIndex){
		Integer bigger = array[leftIndex];
		for (int i = leftIndex+1; i <= rightIndex; i++) {
			if(bigger.compareTo(array[i]) < 0){
				bigger = array[i];
			}
		}
		return bigger;
	}

	private void nullToZero(Integer[] array){
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}

	private void changeArray(Integer[] B, Integer[] array, int rightIndex, int leftIndex){
		int j = 0;
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = B[j];
			j++;
		}
	}

}
