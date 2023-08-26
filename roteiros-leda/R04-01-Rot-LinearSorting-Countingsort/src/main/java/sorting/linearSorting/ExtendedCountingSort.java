package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	// ajustar caso array só de negativos (tá ordenando decrescente)
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
		int neg = findSmaller(array, leftIndex, rightIndex);
		Integer[] C = new Integer[k - neg + 1];
		nullToZero(C);

		for (int i = leftIndex; i <= rightIndex; i++) {
			C[array[i] - neg] += 1;	
		}

		for (int i = 1; i < C.length; i++) {
			C[i] += C[i-1];
		}

		Integer[] B = new Integer[rightIndex+1];
		nullToZero(B);

		for (int i = rightIndex; i >= leftIndex; i--) {
			B[C[array[i]-neg]-1] = array[i];
			C[array[i]-neg] -= 1;
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

	private static int findSmaller(Integer[] array, int leftIndex, int rightIndex){
		Integer smaller = array[leftIndex];
		for (int i = leftIndex+1; i <= rightIndex; i++) {
			if(smaller.compareTo(array[i]) > 0){
				smaller = array[i];
			}
		}
		return smaller;
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
