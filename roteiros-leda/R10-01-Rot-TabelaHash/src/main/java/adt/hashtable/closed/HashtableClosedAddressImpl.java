package adt.hashtable.closed;

import java.util.LinkedList;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddress;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionFactory;
import util.Util;

public class HashtableClosedAddressImpl<T> extends
		AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * 
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * 
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size (or the given size, if it is already prime).
	 * For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 * 
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashtableClosedAddressImpl(int desiredSize,
			HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
			// the immediate prime
			// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method,
				realSize);
		this.hashFunction = function;
	}

	// AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number.
	 * If the given number is prime, it is returned.
	 * You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {
		int prime = number;
		while (!Util.isPrime(prime)) {
			prime += 1;
		}
		return prime;
	}

	@Override
	public void insert(T element) {
		if (element != null && search(element) == null) {
			int hashCode = getHashFunc(element);

			if (table[hashCode] == null)
				table[hashCode] = new LinkedList<T>();
			else
				COLLISIONS += 1;

			LinkedList<T> listTable = ((LinkedList<T>) this.table[hashCode]);
			if (!listTable.contains(element)) {
				listTable.add(element);
				elements += 1;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int hashCode = getHashFunc(element);

			LinkedList<T> listTable = ((LinkedList<T>) this.table[hashCode]);
			if (listTable != null && listTable.contains(element)) {
				if (listTable.size() > 1)
					COLLISIONS -= 1;
				listTable.remove(element);
				elements -= 1;
			}
		}
	}

	@Override
	public T search(T element) {
		T out = null;
		int hashCode = getHashFunc(element);
		int idxElement = indexOf(element);

		if (idxElement != -1) {
			if (((LinkedList<T>) this.table[hashCode]).contains(element)) {
				out = element;
			}
		}
		return out;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		if (element != null) {
			int hashCode = this.getHashFunc(element);
			LinkedList<T> listTable = ((LinkedList<T>) this.table[hashCode]);
			if (listTable != null && listTable.contains(element)) {
				index = hashCode;
			}
		}
		return index;
	}

	private int getHashFunc(T element) {
		return ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);
	}

}
