package jaba.set;

public class ArrayBasedSet implements jaba.set.Set {
    Object[] internalArray;
    int topPosition;

    public ArrayBasedSet(int capacity) {
        internalArray = new Object[capacity];
        topPosition = 0;
    }

    public boolean contains(Object item) {
        for (Object element : internalArray) {
            if (element.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public void add(Object item) {
        if (!contains(item)) {
            if (internalArray.length > topPosition) {
                internalArray[topPosition++] = item;
            } else {
                throw new IndexOutOfBoundsException("Capacity overflow");
            }
        }
    }

    /**
     * Returns the number of elements in this set (its cardinality).  If this
     * set contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this set (its cardinality)
     */
    @Override
    public int size() {
        return topPosition;
    }

    /**
     * Returns <tt>true</tt> if this set contains no elements.
     *
     * @return <tt>true</tt> if this set contains no elements
     */
    @Override
    public boolean isEmpty() {
        return topPosition == 0;
    }

}
