export interface Set<Item> {
    /**
     * Tells if the set contains the specified item.
     */
    contains(item:Item):boolean;

    /**
     * Provides the number of elements in the set.
     */
    size():number;

    /**
     * Tells if the set is empty.
     */
    isEmpty():boolean;
}