package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (Integer integer : array) {
			insert(integer);
		}
		return floor(numero, null);
	}

	private Integer floor(double numero, Integer floor) {
		Integer root = extractRootElement();

		if (root != null) {
			boolean verify = floor == null || root >= floor;
			if (numero >= root && verify) {
				floor = floor(numero, root);
			} else {
				floor = floor(numero, floor);
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (Integer integer : array) {
			insert(integer);
		}
		return ceil(numero, null);
	}

	private Integer ceil(double numero, Integer ceil) {
		Integer root = extractRootElement();

		if (root != null) {
			boolean verify = ceil == null || root <= ceil;
			if (numero <= root && verify) {
				ceil = ceil(numero, root);
			} else {
				ceil = ceil(numero, ceil);
			}
		}
		return ceil;
	}

}
