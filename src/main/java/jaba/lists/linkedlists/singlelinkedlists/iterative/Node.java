package jaba.lists.linkedlists.singlelinkedlists.iterative;

/**
 * Created by Javatlacati on 30/05/2017.
 * @param <Type> Type of contained objects
 * @author Javatlacati
 */
public class Node<Type> {
    private Type item;
    private Node<Type> next;

    public Node(Type item) {
        this.item = item;
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
