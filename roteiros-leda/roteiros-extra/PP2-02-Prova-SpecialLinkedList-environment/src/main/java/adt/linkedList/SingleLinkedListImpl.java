package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int count = 0;
		SingleLinkedListNode<T> nodeAux = this.head;

		while (!nodeAux.isNIL()) {
			count++;
			nodeAux = nodeAux.next;
		}
		return count;
	}

	@Override
	public T search(T element) {
		T out = null;
		SingleLinkedListNode<T> nodeAux = this.head;

		if (element != null) {
			while (!nodeAux.isNIL()) {
				if (nodeAux.getData().equals(element)) {
					out = nodeAux.getData();
				}
				nodeAux = nodeAux.getNext();
			}
		}
		return out;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<T>());
			} else {
				SingleLinkedListNode<T> nodeAux = this.head;

				while (!nodeAux.isNIL()) {
					nodeAux = nodeAux.getNext();
				}
				nodeAux.setData(element);
				nodeAux.setNext(new SingleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (this.head.getData().equals(element)) {
				head = head.next;
			} else {
				SingleLinkedListNode<T> nodeAux = this.head;

				boolean removed = false;
				while (!nodeAux.getNext().isNIL() && !removed) {
					if (nodeAux.getNext().getData().equals(element)) {
						nodeAux.setNext(nodeAux.getNext().getNext());
						removed = true;
					}
					nodeAux = nodeAux.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		SingleLinkedListNode<T> nodeAux = this.head;
		T[] out = (T[]) new Comparable[size()];
		int i = 0;

		if(!isEmpty()){
			while(!nodeAux.isNIL()){
				out[i++] = nodeAux.getData();
				nodeAux = nodeAux.getNext();
			}
		}
		return out;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
