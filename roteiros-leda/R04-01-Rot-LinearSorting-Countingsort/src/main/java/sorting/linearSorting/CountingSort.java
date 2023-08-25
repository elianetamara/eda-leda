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
			int k = findBigger(array, leftIndex, rightIndex);
			Integer[] C = frequency(array, leftIndex, rightIndex, k);
			cumulative(C);
			Integer[] B = sortingIntegers(array, C, rightIndex);
			changeArray(B, array);
		}
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

	private Integer[] frequency(Integer[] array, int leftIndex, int rightIndex, int k){
		// null to zero
		Integer[] C = new Integer[k+1];
		for (int i = leftIndex; i <= rightIndex; i++) {
			C[array[i]] += 1;	
		}
		return C;
	}

	private void cumulative(Integer[] C){
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i-1];
		}
	}

	private Integer[] sortingIntegers(Integer[] array, Integer[] C, int rightIndex){
		// de tras pra frente
		Integer[] B = new Integer[rightIndex+1];
		for (int i = 0; i < rightIndex; i++) {
			B[C[array[i]-1]] = array[i];
		}
		return B;
	}

	private void changeArray(Integer[] B, Integer[] array){
		for (int i = 0; i < B.length; i++) {
			array[i] = B[i];
		}
	}

}
