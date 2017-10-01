package jaba.set;

public interface Set<Item> {
    /**
     * Tells if the set contains the specified item.
     */
    boolean contains(Item item);

    /**
     * Provides the number of elements in the set.
     */
    int size();

    /**
     * Tells if the set is empty.
     */
    boolean isEmpty();
}
