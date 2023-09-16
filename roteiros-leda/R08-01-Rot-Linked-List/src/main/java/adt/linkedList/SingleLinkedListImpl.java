package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> node = getHead();

		while (!node.isNIL()) {
			size++;
			node = node.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> node = getHead();

		if (element != null) {
			while (!node.isNIL() && node.getData() != element) {
				node = node.getNext();
			}
		}

		return (T) node.getData();

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> node = getHead();
			if (node.isNIL()) {
				setHead(new SingleLinkedListNode<T>(element, node));
			} else {
				while (!node.isNIL()) {
					node = node.getNext();
				}
				node.setData(element);
				node.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {
			SingleLinkedListNode<T> node = getHead();
			if (node.getData().equals(element)) {
				setHead(node.getNext());
			} else {
				while (!node.isNIL() && !node.getData().equals(element)) {
					node = node.getNext();
				}
				if (!node.isNIL()) {
					SingleLinkedListNode<T> next = node.getNext();
					node.setData(next.getData());
					node.setNext(next.getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		int count = 0;
		SingleLinkedListNode<T> node = getHead();

		while (!node.isNIL()) {
			array[count++] = node.getData();
			node = node.getNext();
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
