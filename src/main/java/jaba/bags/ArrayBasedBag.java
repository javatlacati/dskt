package jaba.bags;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public class ArrayBasedBag<Item> implements Bag<Item>, Iterable<Item> {

    /**
     * Array that contains the bag elements.
     */
    protected Item[] internalArray;
    /**
     * Number of max 0 based index of used slots in the array.
     */
    protected int topPosition;

    /**
     * Constructs instances of bag class.
     *
     * @param capacity number of elements that this bag can hold.
     */
    public ArrayBasedBag(int capacity) {
        internalArray = (Item[]) new Object[capacity];
        topPosition = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Item item) {
        if (internalArray.length > topPosition) {
            internalArray[topPosition] = item;
            topPosition++;
        } else {
            throw new IndexOutOfBoundsException("Capacity overflow");
        }
    }

    /**
     * indexes are 0 based
     */
    Item getAtIndex(int index) {
        return internalArray[index];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return topPosition == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disposeItems() {
        internalArray = (Item[]) new Object[internalArray.length];
        topPosition = 0;
    }

    /**
     * converts the data structure to an array.
     */
    @Override
    public Item[] toArray() {
        Item[] newArray = (Item[]) new Object[internalArray.length];
        System.arraycopy(internalArray, 0, newArray, 0, internalArray.length);
        return newArray;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return topPosition;
    }

    /**
     * {@inheritDoc}
     * This method performs a lineal search.
     */
    @Override
    public Item find(Item target) {
        return Arrays.stream(internalArray).filter(element -> element.equals(target)).findFirst().orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            /**Index of current element.*/
            private int currentElementIdx = 0;

            /**{@inheritDoc}*/
            @Override
            public boolean hasNext() {
                return currentElementIdx < topPosition;
            }

            /**{@inheritDoc}*/
            @Override
            public Item next() {
                if (currentElementIdx <= topPosition) {
                    final Item result = internalArray[currentElementIdx];
                    currentElementIdx++;
                    return result;
                } else {
                    throw new NoSuchElementException("the element is not present in the aray based bag");
                }
            }

            /**{@inheritDoc}*/
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Bag can't remove elements only add");
            }

            //Java8 an 9 only
            //@Override
            public void forEachRemaining(Consumer<? super Item> action) {
                while (hasNext())
                    action.accept(next());
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void forEach(Consumer<? super Item> action) {
        iterator().forEachRemaining(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Spliterator<Item> spliterator() {
        return new Spliterator<Item>() {
            int currentElementIdx = 0;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean tryAdvance(Consumer<? super Item> action) {
                if (null == action) {
                    throw new NullPointerException();
                }
                if (currentElementIdx < topPosition) {
                    action.accept(internalArray[currentElementIdx]);
                    currentElementIdx++;
                    return true;
                } else {
                    return false;
                }
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public Spliterator<Item> trySplit() {
                return Spliterators.spliterator(
                        Arrays.copyOfRange(internalArray, currentElementIdx, internalArray.length)
                        , IMMUTABLE | SIZED
                );
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public long estimateSize() {
                return size() - currentElementIdx;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED;
            }
        };
    }
}
