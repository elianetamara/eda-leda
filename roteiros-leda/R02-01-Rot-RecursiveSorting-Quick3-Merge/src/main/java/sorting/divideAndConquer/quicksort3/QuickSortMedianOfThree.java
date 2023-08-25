package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean checkParameters = array.length > 1 && leftIndex < rightIndex;
		if(checkParameters){
			int idxPivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, idxPivot-1);
			sort(array, idxPivot+1, rightIndex);

		}
	}

	private int partition (T[] array, int leftIndex, int rightIndex) {
		int idxPivot = getPivotIdx(array, leftIndex, rightIndex);

		Util.swap(array, leftIndex, idxPivot);
		T pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = i + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				Util.swap(array, ++i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}

	private int getPivotIdx(T[] array, int leftIndex, int rightIndex) {
		int out = rightIndex;
		int middle = (leftIndex + rightIndex) / 2;
		T[] pivots = fillPivotsList(array, leftIndex, rightIndex);

		if (pivots[1].compareTo(array[leftIndex]) == 0) {
			out = leftIndex;
		}

		if (pivots[1].compareTo(array[middle]) == 0) {
			out = middle;
		}
		return out;

	}

	private T[] fillPivotsList(T[] array, int leftIndex, int rightIndex){
		T[] pivots = (T[]) new Comparable[3];
		int middle = (leftIndex + rightIndex) / 2;
		pivots[0] = array[leftIndex];
		pivots[1] = array[middle];
		pivots[2] = array[rightIndex];
		insertionSort(array, leftIndex, rightIndex);
		return pivots;
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex+1; i < rightIndex+1; i++) { 
      int j = i;
      while (j > 0 && (array[j].compareTo(array[j - 1]) < 0)) {
				Util.swap(array, j, j-1);
        j -= 1;
      }
    
    }	
	}
}
