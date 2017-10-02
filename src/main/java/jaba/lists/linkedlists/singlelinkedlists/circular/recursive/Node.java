package jaba.lists.linkedlists.singlelinkedlists.circular.recursive;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Administrador on 22/05/2017.
 *
 * @param <T> generic type
 */
public class Node<T> {
    @NotNull private T item;
    @NotNull private Node next;

    @java.beans.ConstructorProperties({"item", "next"})
    public Node(T item, Node next) {
        this.item = item;
        this.next = next;
    }

    //second step
    /**
     * Appends a node at the end.
     */
    synchronized void add(Node newNode) {
        if (next == null) {
            next = newNode;
        } else {
            next.add(newNode);
        }
    }

    synchronized void addAtIndex(Node newNode, int targetIndex, int currentIndex) {
        if (targetIndex == currentIndex) {
            next = newNode;
        } else {
            if (next != null) {
                next.addAtIndex(newNode, targetIndex, 1 + currentIndex);
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
                }else{
                    Node aux= next.getNext();
                    Node aux1=aux.getNext();
                    
                }
            }
        }
    }

    @NotNull
    public T getItem() {
        return this.item;
    }

    @NotNull
    public Node getNext() {
        return this.next;
    }

    public void setItem(@NotNull T item) {
        this.item = item;
    }

    public void setNext(@NotNull Node next) {
        this.next = next;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Node)) return false;
        final Node other = (Node) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$item = this.getItem();
        final Object other$item = other.getItem();
        if (this$item == null ? other$item != null : !this$item.equals(other$item)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $item = this.getItem();
        result = result * PRIME + ($item == null ? 43 : $item.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Node;
    }

    public String toString() {
        return "Node(item=" + this.getItem() + ")";
    }
}
