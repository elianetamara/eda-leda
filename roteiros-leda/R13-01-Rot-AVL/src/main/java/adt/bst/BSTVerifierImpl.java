package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}

	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return getBSt().isEmpty() || isBST(getBSt().getRoot());
	}

	private boolean isBST(BSTNode<T> node) {
		boolean isBST = true;

		if (!node.isEmpty()) {
			if (verifyLeft(node) && verifyRight(node)) {
				isBST = isBST((BSTNode<T>) node.getLeft()) && isBST((BSTNode<T>) node.getRight());
			} else {
				isBST = false;
			}
		}
		return isBST;
	}

	private boolean verifyRight(BSTNode<T> node) {
		return verifyRight(node.getRight(), node);
	}

	private boolean verifyRight(BTNode<T> right, BSTNode<T> node) {
		boolean verify = true;
		if (!right.isEmpty()) {
			if (right.getData().compareTo(node.getData()) > 0) {
				verify = verifyRight(right.getLeft(), node) && verifyRight(right.getRight(), node);
			} else {
				verify = false;
			}
		}
		return verify;
	}

	private boolean verifyLeft(BSTNode<T> node) {
		return verifyLeft(node.getLeft(), node);
	}

	private boolean verifyLeft(BTNode<T> left, BSTNode<T> node) {
		boolean verify = true;
		if (!left.isEmpty()) {
			if (left.getData().compareTo(node.getData()) < 0) {
				verify = verifyLeft(left.getLeft(), node) && verifyRight(left.getRight(), node);
			} else {
				verify = false;
			}
		}
		return verify;
	}

}
