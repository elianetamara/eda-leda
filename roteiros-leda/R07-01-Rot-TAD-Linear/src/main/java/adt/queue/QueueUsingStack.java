package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();

		if (element != null) {
			try {
				stack1.push(element);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();

		T out = null;

		try {
			switchStacks();
			out = stack2.pop();
			switchStacks();
		} catch (StackOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}

		return out;
	}

	@Override
	public T head() {
		T out = null;

		try {
			switchStacks();
			out = stack2.top();
			switchStacks();
		} catch (StackOverflowException | StackUnderflowException e) {
			e.printStackTrace();
		}
		return out;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

	private void switchStacks() throws StackOverflowException, StackUnderflowException {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} else {
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		}
	}

}
