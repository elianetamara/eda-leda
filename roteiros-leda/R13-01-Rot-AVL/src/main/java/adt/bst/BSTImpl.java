package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(getRoot());
	}

	protected int height(BSTNode<T> node) {
		int height = -1;

		if (!node.isEmpty()) {
			height = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> finded = new BSTNode<>();
		if (element != null) {
			finded = search(element, getRoot());
		}
		return finded;
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> finded = new BSTNode<>();

		if (node.isEmpty() || node.getData().equals(element)) {
			finded = node;
		} else {
			if (element.compareTo(node.getData()) < 0) {
				finded = search(element, (BSTNode<T>) node.getLeft());
			} else {
				finded = search(element, (BSTNode<T>) node.getRight());
			}
		}
		return finded;
	}

	@Override
	public void insert(T element) {
		if (element != null)
			insert(element, getRoot());
	}

	private void insert(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setRight(new BSTNode.Builder<T>().parent(node).build());
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert(element, (BSTNode<T>) node.getLeft());
			} else {
				insert(element, (BSTNode<T>) node.getRight());
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> max = null;
		if (!isEmpty()) {
			max = maximum(getRoot());
		}
		return max;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> max = node;
		if (!node.getRight().isEmpty()) {
			max = maximum((BSTNode<T>) node.getRight());
		}
		return max;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> min = null;
		if (!isEmpty()) {
			min = minimum(getRoot());
		}
		return min;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> min = node;
		if (!node.getLeft().isEmpty()) {
			min = minimum((BSTNode<T>) node.getLeft());
		}
		return min;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> sucessor = null;
		if (!node.isEmpty()) {
			BSTNode<T> right = (BSTNode<T>) node.getRight();
			if (!right.isEmpty()) {
				sucessor = minimum(right);
			} else {
				sucessor = sucessor(element, (BSTNode<T>) node.getParent());
			}
		}
		return sucessor;
	}

	private BSTNode<T> sucessor(T element, BSTNode<T> node) {
		BSTNode<T> sucessor;
		if (node == null || node.getData().compareTo(element) > 0) {
			sucessor = node;
		} else {
			sucessor = sucessor(element, (BSTNode<T>) node.getParent());
		}
		return sucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> predecessor = null;
		if (!node.isEmpty()) {
			predecessor = predecessor(element, root);
		}
		return predecessor;
	}

	private BSTNode<T> predecessor(T element, BSTNode<T> node) {
		BSTNode<T> predecessor = null;

		if (!node.isEmpty()) {
			if (node.getData().compareTo(element) < 0) {
				predecessor = node;
				BSTNode<T> rightPred = predecessor(element, (BSTNode<T>) node.getRight());
				if (rightPred != null)
					predecessor = rightPred;
			} else {
				predecessor = predecessor(element, (BSTNode<T>) node.getLeft());
			}
		}
		return predecessor;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				if (node == getRoot()) {
					root = new BSTNode<T>();
				} else {
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
				}
			} else if (node.getRight().isEmpty()) {
				if (node == getRoot()) {
					root = (BSTNode<T>) root.getLeft();
					root.setParent(null);
				} else {
					BSTNode<T> parent = (BSTNode<T>) node.getParent();
					if (node.getLeft().getData().compareTo(parent.getData()) < 0) {
						parent.setLeft(node.getLeft());
					} else {
						parent.setRight(node.getLeft());
					}
					node.getLeft().setParent(parent);
				}
			} else if (node.getLeft().isEmpty()) {
				if (node == getRoot()) {
					root = (BSTNode<T>) root.getRight();
					root.setParent(null);
				} else {
					BSTNode<T> parent = (BSTNode<T>) node.getParent();
					if (node.getRight().getData().compareTo(parent.getData()) < 0) {
						parent.setLeft(node.getRight());
					} else {
						parent.setRight(node.getRight());
					}
					node.getRight().setParent(parent);
				}
			} else {
				T aux = minimum((BSTNode<T>) node.getRight()).getData();
				remove(aux);
				node.setData(aux);
			}
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> preOrder = new ArrayList<>();
		preOrder(getRoot(), preOrder);
		return (T[]) preOrder.toArray(new Comparable[size()]);
	}

	private void preOrder(BSTNode<T> node, ArrayList<T> preOrder) {
		if (!node.isEmpty()) {
			preOrder.add((T) node.getData());
			preOrder((BSTNode<T>) node.getLeft(), preOrder);
			preOrder((BSTNode<T>) node.getRight(), preOrder);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> order = new ArrayList<>();
		order(getRoot(), order);
		return (T[]) order.toArray(new Comparable[size()]);
	}

	private void order(BSTNode<T> node, ArrayList<T> order) {
		if (!node.isEmpty()) {
			order((BSTNode<T>) node.getLeft(), order);
			order.add((T) node.getData());
			order((BSTNode<T>) node.getRight(), order);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> postOrder = new ArrayList<>();
		postOrder(getRoot(), postOrder);
		return (T[]) postOrder.toArray(new Comparable[size()]);
	}

	private void postOrder(BSTNode<T> node, ArrayList<T> postOrder) {
		if (!node.isEmpty()) {
			postOrder((BSTNode<T>) node.getLeft(), postOrder);
			postOrder((BSTNode<T>) node.getRight(), postOrder);
			postOrder.add((T) node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
