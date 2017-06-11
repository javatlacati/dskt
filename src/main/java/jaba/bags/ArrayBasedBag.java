package jaba.bags;

import org.jetbrains.annotations.NotNull;
import sun.plugin.dom.exception.NoModificationAllowedException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayBasedBag implements Bag, Iterable {

    private Object[] internalArray;
    private int topPosition;

    public ArrayBasedBag(int capacity) {
        internalArray = new Object[capacity];
        topPosition = 0;
    }

    @Override
    public void add(Object item) {
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
    public Iterator iterator() {
        return new Iterator() {
            /**Index of current element.*/
            int currentElementIdx = 0;

            @Override
            public boolean hasNext() {
                return topPosition != internalArray.length - 1;
            }

            @Override
            public Object next() {
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
            public void forEachRemaining(Consumer action) {
                while (hasNext())
                    action.accept(next());
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        iterator().forEachRemaining(action);
    }

    @Override
    public Spliterator spliterator() {
        return new Spliterator() {
            @Override
            public boolean tryAdvance(Consumer action) {
                if (action == null)
                    throw new NullPointerException();
                //TODO implement
                return false;
            }

            @Override
            public Spliterator trySplit() {
                //TODO implement
                return null;
            }

            @Override
            public long estimateSize() {
                //TODO implement
                return 0;
            }

            @Override
            public int characteristics() {
                //TODO implement
                return 0;
            }
        };
    }
}
