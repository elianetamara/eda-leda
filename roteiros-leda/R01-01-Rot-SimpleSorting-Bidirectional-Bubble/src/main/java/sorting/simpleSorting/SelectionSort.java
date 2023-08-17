package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean checkParameters = array.length > 0 && rightIndex <= array.length-1 && leftIndex >= 0;
		
		if(checkParameters){
			for (int i = leftIndex; i <= rightIndex; i++) {
				int smallestIndex = findSmallest(array, i, rightIndex);
				Util.swap(array, i, smallestIndex);
			}
		}
	}

	private int findSmallest(T[] array, int i, int rightIndex){
		int smallest = i;
		for (int j = i+1; j <= rightIndex; j++) {
			if(array[j].compareTo(array[smallest]) < 0){
				smallest = j;
			}
		}
		return smallest;
	}

}
