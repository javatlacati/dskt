package jaba.linkedlists.singlelinkedlists.iterative;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

@Setter
@Getter
@EqualsAndHashCode(of = "root")
public class SingleLinkedList {
    private Node root;

    public String getStrings() {
        if (root == null) {
            return "";
        } else {
            String salida = root.toString();
            Node actual = root;
            while (actual.getNext() != null) {
                actual = actual.getNext();
                salida += actual.toString();
            }
            return salida;
        }
    }

    public void addAtEnd(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            Node actual = root;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(newNode);
        }
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
        if (index == 0) {
            addAtRoot(newNode);
        } else {
            if (index > 0) {
                Node currentNode = root.getNext();
                for (int currentIndex = 1; currentIndex < index; currentIndex++) {
                    Node next = currentNode.getNext();
                    if (next != null) {
                        currentNode = next;
                    } else {
                        throw new IndexOutOfBoundsException("the specified index is not possible to reach");
                    }
                }
                currentNode.setNext(newNode);
            } else {
                throw new IndexOutOfBoundsException("no negative index values allowed");
            }
        }
    }

    public void addSingleLinkedListAtRoot(SingleLinkedList singleLinkedList) {
        singleLinkedList.addAtEnd(root);
        root = singleLinkedList.getRoot();
    }

    public void addSingleLinkedListAtEnd(SingleLinkedList singleLinkedList) {
        addAtRoot(singleLinkedList.getRoot());
    }

    public void printList() {
        System.out.println(getStrings());
    }

    public void removeLast() {
        if (root != null) {
            if (root.getNext() == null) {
                root = null;
            } else {
                Node currentNode = root;
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                if (currentNode.getNext() == null) {
                    currentNode.setNext(null);
                }
            }
        }
    }
}
