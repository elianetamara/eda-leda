package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T> {

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam
     * criados
     * nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node) {
        SingleLinkedListNode<T> nodeAux;

        while (!node.isNIL()) {
            nodeAux = node;
            while (!nodeAux.isNIL() && !nodeAux.getNext().isNIL()) {
                if (nodeAux.getNext().getData().equals(node.getData())) {
                    removeNode(nodeAux);
                } else {
                    nodeAux = nodeAux.getNext();
                }
            }
            node = node.getNext();
        }

    }

    private void removeNode(SingleLinkedListNode<T> nodeAux) {
        if (!nodeAux.isNIL()) {
            nodeAux.setNext(nodeAux.getNext().getNext());
        }
    }
}
