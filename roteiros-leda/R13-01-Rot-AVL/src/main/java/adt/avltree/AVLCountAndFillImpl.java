package adt.avltree;

import java.util.Arrays;
import java.util.HashSet;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		HashSet<T> set = new HashSet<>();
		T[] bstArray = order();

		for (int i = 0; i < bstArray.length; i++) {
			set.add(bstArray[i]);
		}

		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		array = (T[]) set.toArray(new Comparable[0]);
		Arrays.sort(array);

		this.root = new BSTNode<>();

		int level = 0;
		while (fillWithoutRebalance(0, array.length, level, array)) {
			level++;
		}
	}

	private boolean fillWithoutRebalance(int left, int right, int level, T[] array) {
		boolean filled = false;

		if (right > left) {
			int middle = left + (right - left) / 2;
			if (level == 0) {
				insert(array[middle]);
				filled = true;
			} else {
				filled = fillWithoutRebalance(left, middle, level - 1, array);
				filled = fillWithoutRebalance(middle + 1, right, level - 1, array);
			}
		}

		return filled;
	}

}
