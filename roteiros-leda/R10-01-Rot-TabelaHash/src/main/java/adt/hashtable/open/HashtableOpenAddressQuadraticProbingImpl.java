package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull())
			throw new HashtableOverflowException();

		if (element != null && search(element) == null) {
			int prob = 0;

			while (prob < table.length) {
				int hashCode = getHashFunc(element, prob);

				if (table[hashCode] == null || table[hashCode].equals(deletedElement)) {
					table[hashCode] = element;
					elements += 1;
					break;
				} else {
					prob += 1;
					COLLISIONS += 1;
				}
			}

			if (prob == table.length)
				throw new HashtableOverflowException();
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !this.isEmpty()) {
			int prob = 0;

			while (prob < table.length) {
				int hashCode = getHashFunc(element, prob);

				if (table[hashCode] != null) {
					if (table[hashCode].equals(element)) {
						table[hashCode] = deletedElement;
						elements -= 1;
						break;
					}
					prob += 1;
				} else {
					break;
				}
			}
		}
	}

	@Override
	public T search(T element) {
		T out = null;
		if (indexOf(element) != -1)
			out = element;
		return out;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;

		if (element != null) {
			int prob = 0;

			while (prob < table.length) {
				int hashCode = getHashFunc(element, prob);

				if (table[hashCode] != null) {
					if (table[hashCode].equals(element)) {
						index = hashCode;
						break;
					}
					prob += 1;
				} else {
					break;
				}
			}
		}
		return index;
	}

	private int getHashFunc(T element, int prob) {
		return ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, prob);
	}

}
