namespace bags
{
    public interface Bag<Item>
    {
        /// <summary> 
        /// Adds an item to the bag.
        /// </summary>
        /// <param name="item">item to be added to the bag</param>
        void add(Item item);

        /// <summary> 
        /// Checks if the bag is empty.
        /// </summary>
        /// <returns>
        /// <code>true</code> if the bag is empty, <code>false</code> otherwise
        /// </returns>
        boolean isEmpty();

        /// <summary> 
        /// Returns how many items it contains.
        /// </summary> 
        /// <returns>
        /// number of contained elements
        /// </returns>
        int size();


        /// <summary>
        /// Searches for an Item.
        /// </summary>
        /// <param name="target">element to be searched</param>
        /// <returns>a pointer to the Item if exists in the collection, null otherwise</returns>
        Item find(Item target);

        /// <summary>
        /// Makes this bag empty.
        /// </summary>
        void disposeItems();
    }


    public class ArrayBasedBag<Item> : Bag<Item>
    {
        
    }
}