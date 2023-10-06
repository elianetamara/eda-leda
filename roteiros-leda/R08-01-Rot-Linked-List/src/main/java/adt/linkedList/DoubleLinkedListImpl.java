package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<>();
		this.head = this.last;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {

			DoubleLinkedListNode<T> oldHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<>();
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, oldHead, nilNode);

			nilNode.setNext(newHead);
			oldHead.setPrevious(newHead);
			if (this.getHead().isNIL()) {
				this.setLast(newHead);
			}
			this.setHead(newHead);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.setHead(this.getHead().getNext());
			DoubleLinkedListNode<T> newLast = (DoubleLinkedListNode<T>) this.getHead();
			if (this.getHead().isNIL()) {
				this.setLast(newLast);
			}
			newLast.setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			this.setLast(this.getLast().getPrevious());
			if (this.getLast().isNIL()) {
				this.setHead(this.getLast());
			} else {
				DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<>();
				this.getLast().setNext(nilNode);
				nilNode.setPrevious(this.getLast());
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {

			DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<>();
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, nilNode, this.getLast());

			nilNode.setPrevious(newHead);
			this.getLast().setNext(newHead);

			if (this.getLast().isNIL())
				this.setHead(newHead);

			this.setLast(newHead);
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !this.isEmpty()) {

			if (this.getHead().getData().equals(element)){
				this.removeFirst();
			}else if (this.getLast().getData().equals(element)){
				this.removeLast();
			}else {
				DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) this.getHead();
				while (!node.isNIL() && !node.getData().equals(element))
					node = (DoubleLinkedListNode<T>) node.getNext();
				if (!node.isNIL()) {
					DoubleLinkedListNode<T> nodePrev = node.getPrevious();
					DoubleLinkedListNode<T> nodeNext = (DoubleLinkedListNode<T>) node.getNext();

					nodePrev.setNext(nodeNext);
					nodeNext.setPrevious(nodePrev);
				}
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
