package jaba.queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;

/**
 * The time needed to add or delete an item is constant and independent of the number of items in the queue. So both addition and deletion can be O(1) operation.
 */
public class ArrayBasedQueue<Type> implements Queue<Type> {
    /**
     * number of elements that the queue can hold.
     */
    protected int capacity;
    /**
     * Internal array to hold the data.
     */
    Type[] queueArray;

    private int headIndex = 0;

    public ArrayBasedQueue(int queueSize) {
        capacity = queueSize;
        queueArray = (Type[]) new Object[capacity];
    }

    @Override public int size() {
        return headIndex;
    }

    public boolean isEmpty() {
        return 0 == headIndex;
    }

    @Override public boolean contains(Object o) {
        return Arrays.stream(queueArray).limit(headIndex).anyMatch(type -> type.equals(o));
    }

    @NotNull @Override public Iterator<Type> iterator() {
        return Arrays.asList(queueArray).iterator();
    }

    @NotNull @Override public Object[] toArray() {
        return Arrays.copyOf(queueArray,headIndex);
    }

//    public <T> T[] toArray(@NotNull T[] resultingArray) {
//        int size = size();
//        if (size != 0) {
//            for (int i = 0; i < resultingArray.length; i++) {
//                final T t = queueArray.length > i ? (T) queueArray[i] : null;
//                resultingArray[i] = t;
//            }
//        }
//        return resultingArray;
//    }

    @NotNull @Override public <T> T[] toArray(@NotNull T[] a) {
        Arrays.setAll(a, idx -> idx<queueArray.length?(T) (queueArray[idx]):null);
        return a;
    }

    public boolean isFull() {
        return headIndex == capacity;
    }

    public synchronized boolean enqueue(Type type) {
        if (isFull()) {
            throw new OutOfMemoryError("Queue Capacity has been excedeed");
        } else {
            queueArray[headIndex] = type;
            headIndex++;
            return true;
        }
    }

    public synchronized Type dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue Undeflow");
        } else {
            final Type dequeued = queueArray[0];
            final int length = queueArray.length - 1;
            System.arraycopy(queueArray, 1, queueArray, 0, length);
            headIndex--;
            return dequeued;
        }
    }

    public int getCurrentSize() {
        return capacity - headIndex;
    }

    public void makeEmpty() {
        headIndex = 0;
    }

    public String toString() {
        return "ArrayBasedQueue(queueArray=" + java.util.Arrays.deepToString(toArray()) + ")";
    }

    public int getCapacity() {
        return capacity;
    }

//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }

    @Override public boolean add(Type type) {
        return enqueue(type);
    }

    @Override public boolean remove(Object o) {
        return null == dequeue();
    }

    @Override public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override public boolean addAll(@NotNull Collection<? extends Type> c) {
        return c.stream().allMatch(this::add);
    }

    @Override public boolean removeAll(@NotNull Collection<?> c) {
        return c.stream().allMatch(this::remove);
    }

    @Override public boolean retainAll(@NotNull Collection<?> c) {
        return this.stream().filter(o -> !c.contains(o)).allMatch(this::remove);
    }

    @Override public void clear() {
        makeEmpty();
    }

    @Override public boolean offer(Type type) {
        return false;
    }

    @Override public Type remove() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }else{
            return dequeue();
        }
    }

    @Override public Type poll() {
        return dequeue();
    }

    @Override public Type element() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }else{
            return peek();
        }
    }

    @Override public Type peek() {
        return queueArray[headIndex];
    }
}
