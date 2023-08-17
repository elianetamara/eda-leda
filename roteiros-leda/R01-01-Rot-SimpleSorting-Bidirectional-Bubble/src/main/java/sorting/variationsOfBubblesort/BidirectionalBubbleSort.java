package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean checkParameters = array.length > 0 && rightIndex <= array.length-1 && leftIndex >= 0;
		
		if(checkParameters){
			for (int i = leftIndex; i < rightIndex; i++) {
				leftToRight(array, leftIndex, rightIndex, i);
				rightToLeft(array, leftIndex, rightIndex);
			}
		}
	}

	private void leftToRight(T[] array, int leftIndex, int rightIndex, int i){
		for (int j = leftIndex; j < rightIndex - i; j++) {
			if(array[j].compareTo(array[j+1]) > 0){
				Util.swap(array, j, j+1);
			}
		}
	}

	private void rightToLeft(T[] array, int leftIndex, int rightIndex){
		for (int j = rightIndex; j < leftIndex; j--) {
			if(array[j].compareTo(array[j-1]) < 0){
				Util.swap(array, j, j-1);
			}
		}
	}
}
