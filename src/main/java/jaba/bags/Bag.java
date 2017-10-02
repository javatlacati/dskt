package jaba.bags;

/**
 * A Bag is a simple datastructure that holds items and can be emptied.
 * <code>Te hace falta ver mas bags :v</code>
 */
public interface Bag<Item> {
    /**
     * Adds an item to the bag.
     *
     * @param item item to be added to the bag
     */
    void add(Item item);

    /**
     * Checks if the bag is empty.
     */
    boolean isEmpty();

    /**
     * Returns how many items it contains.
     */
    int size();

    /**
     * Searches for an Item.
     *
     * @param target element to be searched
     */
    Item find(Item target);

    /**
     * Makes this bag empty.
     */
    void disposeItems();
}
