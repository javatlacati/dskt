package jaba.lists.linkedlists.singlelinkedlists.circular.iterative;


import org.jetbrains.annotations.NotNull;

/**
 * Created by Core i7 on 30/05/2017.
 */
public class Node {
    @NotNull
    private Object item;
    @NotNull private Node next;

    @java.beans.ConstructorProperties({"item", "next"})
    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @NotNull
    public Object getItem() {
        return this.item;
    }

    @NotNull
    public Node getNext() {
        return this.next;
    }

    public void setItem(@NotNull Object item) {
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
