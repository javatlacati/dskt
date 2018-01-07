package jaba.bags;

/**
 * A Bag is a simple datastructure that holds items and can be emptied.
 * {@code Te hace falta ver mas bags :v}
 *
 * @param <Item> Class of contained elements
 */
public interface Bag<Item> {
    /**
     * Adds an item to the bag.
     *
     * @param item item to be added to the bag
     */
    @SuppressWarnings("NonBooleanMethodNameMayNotStartWithQuestion")
    void add(Item item);

    /**
     * Checks if the bag is empty.
     *
     * @return {@code true} if the bag is empty, {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Returns how many items it contains.
     *
     * @return number of contained elements
     */
    int size();

    /**
     * Searches for an Item.
     *
     * @param target element to be searched
     * @return a pointer to the Item if exists in the collection, null otherwise
     */
    Item find(Item target);

    /**
     * Makes this bag empty.
     */
    void disposeItems();
}
