package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean checkParameters = array.length > 0 && rightIndex <= array.length-1 && leftIndex >= 0;
		if(checkParameters){
			if(leftIndex < rightIndex){
				int smallestIndex = findSmallest(array, leftIndex, rightIndex, leftIndex);
				Util.swap(array, leftIndex, smallestIndex);
				sort(array, leftIndex+1, rightIndex);
			}
		}
	}

	private int findSmallest(T[] array, int leftIndex, int rightIndex, int smallest){
		int smallestIndex;
		if(leftIndex < rightIndex){
			if(array[smallest].compareTo(array[leftIndex+1]) > 0){
					smallest = leftIndex+1;
			}
			smallestIndex = findSmallest(array, leftIndex+1, rightIndex, smallest);
		}else{
			smallestIndex = smallest;
		}
		return smallestIndex;
	}

}
