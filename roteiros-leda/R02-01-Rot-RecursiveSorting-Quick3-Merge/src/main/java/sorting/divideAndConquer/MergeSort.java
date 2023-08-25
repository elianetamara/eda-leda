package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean checkParameters = array.length > 0 && rightIndex <= array.length-1 && leftIndex >= 0;
		if (checkParameters) {
			if (leftIndex < rightIndex) {
				int middle = (leftIndex + rightIndex) / 2;
				sort(array, leftIndex, middle);
				sort(array, middle + 1, rightIndex);
				merge(array, leftIndex, middle, rightIndex);
			}
		}
	}

	private void merge (T[] array, int leftIndex, int middle, int rightIndex) {
		T[] C = array.clone();
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while (i <= middle && j <= rightIndex) {
			if (C[i].compareTo(C[j]) <= 0) {
				array[k++] = C[i++];
			} else {
				array[k++] = C[j++];
			}
		}

		while (i <= middle) {
			array[k++] = C[i++];
		}

		while (j <= rightIndex) {
			array[k++] = C[j++];
		}
	}
	
}
