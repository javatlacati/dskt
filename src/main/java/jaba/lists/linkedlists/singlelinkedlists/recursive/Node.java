package jaba.lists.linkedlists.singlelinkedlists.recursive;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Administrador on 22/05/2017.
 *
 * @param <Type> generic type
 */
public class Node<Type> {

    private Type item;
    private Node<Type> next;

    public Node(@NotNull Type item) {
        this.item = item;
    }

    //second step

    /**
     * Appends a node at the end.
     * @param newNode node to be addeded to singly linked list
     */
    synchronized void add(Node<Type> newNode) {
        if (null == next) {
            next = newNode;
        } else {
            next.add(newNode);
        }
    }

    synchronized void addAtIndex(Type element, int targetIndex, int currentIndex) {
        if (targetIndex == (currentIndex + 1)) {
            Node<Type> aux = next;
            next = new Node<>(element);
            next.setNext(aux);
        } else {
            if (null != next) {
                next.addAtIndex(element, targetIndex, 1 + currentIndex);
            } else {
                throw new IndexOutOfBoundsException("the specified index is not possible to reach");
            }
        }
    }

    String getStrings() {
        return (null == next) ? toString() : (toString() + next.getStrings());
    }

    void removeLast() {
        if (null != next) {
            if (null == next.getNext()) {
                next = null;
            } else {
                next.removeLast();
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
        return item.equals(o) || ((null != next) && next.contains(o));
    }

    public Type[] toArray() {
        final Type[] internalArray = privateCreateArray(1);
        internalArray[0] = item;
        return (null == next) ? internalArray : next.toArray(2, internalArray);
    }

    private Type[] toArray(int i, Type[] internalArray) {
        internalArray[i - 1] = item;
        return (null == next) ? internalArray : next.toArray(i + 1, internalArray);
    }

    Type[] privateCreateArray(int i) {
        return (null == next) ? (Type[]) new Object[i] : next.privateCreateArray(i + 1);
    }

    public void reverse(Node<Type> currentHead, Node<Type> root) {
        if(root.getNext()==null){
            //we are done
            root.setNext(currentHead);
        }else{
            root=root.next;
            if(currentHead.getNext().equals(root)){
                currentHead.setNext(null);
                Node<Type> aux = root;
                root=root.getNext();
                aux.setNext(currentHead);
                currentHead=aux;
                reverse(currentHead,root);
            }else{

            }
        }
    }

    public Type getItem() {
        return this.item;
    }

    public Node<Type> getNext() {
        return this.next;
    }

    public void setItem(Type item) {
        this.item = item;
    }

    public void setNext(Node<Type> next) {
        this.next = next;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Node)) return false;
        final Node other = (Node) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$item = this.getItem();
        final Object other$item = other.getItem();
        return (null == this$item) ? (null == other$item) : this$item.equals(other$item);
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
