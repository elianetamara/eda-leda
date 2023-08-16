package sorting.simpleSorting;

import java.util.Arrays;

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
		if(array.length > 0  && rightIndex <= array.length-1 && leftIndex >= 0){
			for (int i = leftIndex; i <= rightIndex; i++) {
				int menor_index = i;
				for (int j = i+1; j <= rightIndex; j++) {
					if(array[j].compareTo(array[menor_index]) < 0){
						menor_index = j;
					}
				}
			Util.swap(array, i, menor_index);
		}
		}
	}

	public static void main(String[] args){
        Integer[] array = new Integer[]{6, 1, 5, 3, 8, 13, 9};
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        selectionSort.sort(array, 0, 5);
        System.out.println(Arrays.toString(array));

    }
}
