package jaba.bags;

import org.jetbrains.annotations.NotNull;
import sun.plugin.dom.exception.NoModificationAllowedException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public class ArrayBasedBag<Item> implements Bag<Item>, Iterable<Item> {

    private Item[] internalArray;
    private int topPosition;

    public ArrayBasedBag(int capacity) {
        internalArray = (Item[]) new Object[capacity];
        topPosition = 0;
    }

    @Override
    public void add(Item item) {
        if (internalArray.length > topPosition) {
            internalArray[topPosition++] = item;
        } else {
            throw new IndexOutOfBoundsException("Capacity overflow");
        }
    }

    @Override
    public boolean isEmpty() {
        return topPosition == 0;
    }

    @Override
    public int size() {
        return topPosition;
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            /**Index of current element.*/
            int currentElementIdx = 0;

            @Override
            public boolean hasNext() {
                return topPosition != internalArray.length - 1;
            }

            @Override
            public Item next() {
                if (currentElementIdx <= topPosition) {
                    return internalArray[currentElementIdx++];
                } else {
                    return null;
                }
            }

            @Override
            public void remove() {
                throw new NoModificationAllowedException("Bag can't remove elements only add");
            }

            //Java8 only
            //@Override
            public void forEachRemaining(Consumer<? super Item> action) {
                while (hasNext())
                    action.accept(next());
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        iterator().forEachRemaining(action);
    }

    @Override
    public Spliterator<Item> spliterator() {
        return new Spliterator<Item>() {
            int currentElementIdx = 0;

            @Override
            public boolean tryAdvance(Consumer<? super Item> action) {
                if (action == null) {
                    throw new NullPointerException();
                }
                if (currentElementIdx < topPosition) {
                    action.accept(internalArray[currentElementIdx++]);
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Spliterator<Item> trySplit() {
                return Spliterators.spliterator(
                        Arrays.copyOfRange(internalArray, currentElementIdx, internalArray.length)
                        , IMMUTABLE | SIZED
                );
            }

            @Override
            public long estimateSize() {
                return size() - currentElementIdx;
            }

            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED;
            }
        };
    }
}
