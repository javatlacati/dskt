package jaba.queue.deque;

import jaba.queue.ArrayBasedQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Administrador on 07/06/2017.
 */

public class ArrayBasedDeque<Type> implements Deque<Type> {

    /**
     * number of elements that the queue can hold.
     */
    protected int capacity;
    /**
     * Internal array to hold the data.
     */
    Type[] queueArray;

    private int headIndex;

    public ArrayBasedDeque(int queueSize) {
        queueArray = (Type[]) new Object[capacity];
        headIndex=0;
    }

  public String toString() {
    return "ArrayBasedDeque(dequeArray=" + java.util.Arrays.deepToString(this.dequeArray) + ")";
  }

    @Override public void addFirst(Type type) {
        if(headIndex==0){
            addLast(type);
        }else {
            System.arraycopy(queueArray, 1, queueArray, 0, queueArray.length);
            queueArray[0]=type;
        }
    }

    @Override public void addLast(Type type) {
        final int headIndex1 = this.headIndex + 1;
        if(queueArray.length>headIndex1) {
            headIndex= headIndex1;
            queueArray[headIndex]=type;
        }else {
            throw new OutOfMemoryError("Queue Capacity has been excedeed");
        }
    }

    @Override public boolean offerFirst(Type type) {
        return false;
    }

    @Override public boolean offerLast(Type type) {
        return false;
    }

    @Override public Type removeFirst() {
        return null;
    }

    @Override public Type removeLast() {
        return null;
    }

    @Override public Type pollFirst() {
        return null;
    }

    @Override public Type pollLast() {
        return null;
    }

    @Override public Type getFirst() {
        return null;
    }

    @Override public Type getLast() {
        return null;
    }

    @Override public Type peekFirst() {
        return null;
    }

    @Override public Type peekLast() {
        return null;
    }

    @Override public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override public boolean add(Type type) {
        return false;
    }

    @Override public boolean offer(Type type) {
        return false;
    }

    @Override public Type remove() {
        return null;
    }

    @Override public Type poll() {
        return null;
    }

    @Override public Type element() {
        return null;
    }

    @Override public Type peek() {
        return null;
    }

    @Override public void push(Type type) {

    }

    @Override public Type pop() {
        return null;
    }

    @Override public boolean remove(Object o) {
        return false;
    }

    @Override public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override public boolean addAll(@NotNull Collection<? extends Type> c) {
        return false;
    }

    @Override public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override public void clear() {

    }

    @Override public boolean contains(Object o) {
        return false;
    }

    @Override public int size() {
        return 0;
    }

    @Override public boolean isEmpty() {
        return false;
    }

    @Override public Iterator<Type> iterator() {
        return null;
    }

    @NotNull @Override public Object[] toArray() {
        return new Object[0];
    }

    @NotNull @Override public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @NotNull @Override public Iterator<Type> descendingIterator() {
        return null;
    }
}
