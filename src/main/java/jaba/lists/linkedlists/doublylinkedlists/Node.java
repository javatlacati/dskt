package jaba.lists.linkedlists.doublylinkedlists;

/**
 *
 * @author Core i7
 */
public class Node<Type> {

    Type item;
    Node previous;
    Node next;

    public Node(Type item) {
        this.item = item;
    }

    @java.beans.ConstructorProperties({"item", "previous", "next"})
    public Node(Type item, Node previous, Node next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    public Object getItem() {
        return this.item;
    }

    public Node getPrevious() {
        return this.previous;
    }

    public Node getNext() {
        return this.next;
    }

    public void setItem(Type item) {
        this.item = item;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
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
