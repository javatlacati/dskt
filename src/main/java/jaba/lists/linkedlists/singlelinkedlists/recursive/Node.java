package jaba.lists.linkedlists.singlelinkedlists.recursive;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrador on 22/05/2017.
 *
 * @param <Type> generic type
 */
@Setter
@Getter
@EqualsAndHashCode(of = {"item"})
@ToString(of = "item")
public class Node<Type> {

    private Type item;
    private Node<Type> next;

    public Node(Type item) {
        this.item = item;
    }

    //second step

    /**
     * Appends a node at the end.
     */
    synchronized void add(Node<Type> newNode) {
        if (next == null) {
            next = newNode;
        } else {
            next.add(newNode);
        }
    }

    synchronized void addAtIndex(Type element, int targetIndex, int currentIndex) {
        if (targetIndex == currentIndex) {
            next = new Node<>(element);
        } else {
            if (next != null) {
                next.addAtIndex(element, targetIndex, 1 + currentIndex);
            } else {
                throw new IndexOutOfBoundsException("the specified index is not possible to reach");
            }
        }
    }

    String getStrings() {
        return next == null ? toString() : toString() + next.getStrings();
    }

    void removeLast() {
        if (next != null) {
            if (next.getNext() == null) {
                next = null;
            } else {
                next.removeLast();
            }
        }
    }

    void reverse() {
        if (next != null) {
            if (next.getNext() != null) {
                if (next.getNext().getNext() != null) {
                    next.getNext().reverse();
                } else {
                    Node<Type> aux = next.getNext();
                    Node<Type> aux1 = aux.getNext();

                }
            }
        }
    }

    public int size(int i) {
        if (next == null) {
            return i;
        } else {
            int i1 = i + 1;
            return next.size(i1);
        }
    }

    /**
     * rercursive implementation!
     */
    public boolean contains(Type o) {
        if (item.equals(o)) {
            return true;
        } else {
            return next != null && next.contains(o);
        }
    }

    public Type[] toArray() {
        Type[] internalArray = privateCreateArray(1);
        internalArray[0] = item;
        if (next != null) {
            return next.toArray(2, internalArray);
        } else {
            return internalArray;
        }
    }

    private Type[] toArray(int i, Type[] internalArray) {
        internalArray[i - 1] = item;
        if (next != null) {
            return next.toArray(i + 1, internalArray);
        } else {
            return internalArray;
        }
    }

    Type[] privateCreateArray(int i) {
        if (next == null) {
            return (Type[]) new Object[i];
        } else {
            return next.privateCreateArray(i + 1);
        }
    }
}
