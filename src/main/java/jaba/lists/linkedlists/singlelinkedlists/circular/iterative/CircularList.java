package jaba.lists.linkedlists.singlelinkedlists.circular.iterative;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Setter
@Getter
@EqualsAndHashCode(of = "root")
@Log
public class CircularList {
    private Node root;

    public String getStrings() {
        if (null == root) {
            return "";
        } else {
            StringBuilder salida = new StringBuilder(root.toString());
            Node actual = root;
            while (actual.getNext() != root) {
                actual = actual.getNext();
                salida.append(actual);
            }
            return salida.toString();
        }
    }

    public void addAtEnd(Node newNode) {
        if (null == root) {
            root = newNode;
        } else {
            Node actual = root;
            while (actual.getNext() != root) {
                actual = actual.getNext();
            }
            actual.setNext(newNode);
        }
        newNode.setNext(root);
    }

    public void addAtRoot(Node newNode) {
        newNode.setNext(root);
        root = newNode;
    }

    /**
     * Index is 0 base
     *
     * @param newNode
     * @param index
     */
    public void addAtIndex(Node newNode, int index) {
        if (0 == index) {
            addAtRoot(newNode);
        } else {
            if (0 < index) {
                Node currentNode = root.getNext();
                for (int currentIndex = 1; currentIndex < index; currentIndex++) {
                    Node next = currentNode.getNext();
                    if (null == next) {
                        throw new IndexOutOfBoundsException("the specified index is not possible to reach");
                    } else {
                        currentNode = next;
                    }
                }
                currentNode.setNext(newNode);
            } else {
                throw new IndexOutOfBoundsException("no negative index values allowed");
            }
        }
    }

    public void addSingleLinkedListAtRoot(CircularList singleLinkedList) {
        singleLinkedList.addAtEnd(root);
        root = singleLinkedList.getRoot();
    }

    public void addSingleLinkedListAtEnd(CircularList singleLinkedList) {
        addAtRoot(singleLinkedList.getRoot());
    }

    public void printList() {
        log.info(getStrings());
    }

    public void removeLast() {
        if (null != root) {
            if (null == root.getNext()) {
                root = null;
            } else {
                Node currentNode = root;
                while (null != currentNode.getNext()) {
                    currentNode = currentNode.getNext();
                }
                if (null == currentNode.getNext()) {
                    currentNode.setNext(null);
                }
            }
        }
    }
}
