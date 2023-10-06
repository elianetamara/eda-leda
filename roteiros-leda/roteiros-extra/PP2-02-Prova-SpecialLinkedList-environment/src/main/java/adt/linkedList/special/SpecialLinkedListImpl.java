package adt.linkedList.special;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SpecialLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SpecialLinkedList<T> {

	@Override
	public void swap(T elem1, T elem2) {
		// procura os nos pra salvar eles numa variavel e depois fazer a troca dos **valores**
		if (!isEmpty() && elem1 != null && elem2 != null) {
			SingleLinkedListNode<T> nodeAux = this.head;

			SingleLinkedListNode<T> node1 = null;
			SingleLinkedListNode<T> node2 = null;

			while (!nodeAux.isNIL()) {
				if (nodeAux.getData().equals(elem1)) {
					node1 = nodeAux;
				} else if (nodeAux.getData().equals(elem2)) {
					node2 = nodeAux;
				}
				nodeAux = nodeAux.getNext();
			}

			if (node1 != null && node2 != null) {
				T nodeValue = node1.getData();
				node1.setData(node2.getData());
				node2.setData(nodeValue);
			}
		}
	}

	@Override
	public T elementFromTheEnd(int k) {
		T value = null;
		if (!isEmpty()) {
			SingleLinkedListNode<T> nodeAux = this.head;
			SingleLinkedListNode<T> nodeResult = this.head;
			int count = 1;

			while (!nodeAux.isNIL()) {
				if (count >= k) {
					value = nodeResult.getData();
					nodeResult = nodeResult.getNext();
				}
				nodeAux = nodeAux.getNext();
				count++;
			}
		}
		return value;
	}

}
