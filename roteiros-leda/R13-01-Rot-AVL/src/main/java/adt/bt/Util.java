package adt.bt;

import adt.bst.BSTNode;

public class Util {

	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * 
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> root = (BSTNode<T>) node.getRight();
		root.setParent(node.getParent());

		node.setRight(root.getLeft());
		root.setLeft(node);

		node.setParent(root);
		node.getRight().setParent(node);

		if (root.getParent() != null) {
			if (root.getParent().getRight().equals(node)) {
				root.getParent().setRight(root);
			} else {
				root.getParent().setLeft(root);
			}
		}

		return root;
	}

	public static <T extends Comparable<T>> BSTNode<T> doubleLeftRotation(BSTNode<T> node) {
		rightRotation((BSTNode<T>) node.getRight());
		return leftRotation(node);
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * 
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> root = (BSTNode<T>) node.getLeft();
		root.setParent(node.getParent());

		node.setLeft(root.getRight());
		root.setRight(node);

		node.setParent(root);
		node.getLeft().setParent(node);

		if (root.getParent() != null) {
			if (root.getParent().getLeft().equals(node)) {
				root.getParent().setLeft(root);
			} else {
				root.getParent().setRight(root);
			}
		}

		return root;
	}

	public static <T extends Comparable<T>> BSTNode<T> doubleRightRotation(BSTNode<T> node) {
		leftRotation((BSTNode<T>) node.getLeft());
		return rightRotation(node);
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
