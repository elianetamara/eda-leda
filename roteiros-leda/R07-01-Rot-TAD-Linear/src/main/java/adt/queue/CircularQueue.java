package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else if (element != null) {
			if (isEmpty())
				head++;
			tail = (tail + 1) % array.length;
			array[tail] = element;
			elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();

		T out = null;
		if (head == tail) {
			out = array[head];
			head--;
			tail--;
		} else {
			head = (head + 1) % array.length;
			out = array[head];
			elements--;
		}

		return out;
	}

	@Override
	public T head() {
		T out = null;
		if (!isEmpty())
			out = this.array[head];

		return out;
	}

	@Override
	public boolean isEmpty() {
		return head == -1 && tail == -1;
	}

	@Override
	public boolean isFull() {
		return ((tail + 1) % array.length) == head;
	}

}
