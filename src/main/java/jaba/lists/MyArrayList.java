package jaba.lists;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyArrayList<Type> implements MyList<Type> {
    private int size;
    private Type[] internalArray;

    private static final int CAPACITY = 10;

    public MyArrayList() {
        internalArray = (Type[]) new Object[CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        if(object == null){
            return false;
        }
        Type typedObject = (Type) object;
        return Arrays.stream(internalArray).anyMatch( x-> x.equals( typedObject));
    }

    @NotNull
    @Override
    public Iterator<Type> iterator() {
        return new Iterator<Type>() {
            /**Index of current element.*/
            private int currentElementIdx = 0;

            /**{@inheritDoc}*/
            @Override
            public boolean hasNext() {
                return currentElementIdx < size;
            }

            /**{@inheritDoc}*/
            @Override
            public Type next() {
                if (currentElementIdx <= size) {
                    final Type result = internalArray[currentElementIdx];
                    currentElementIdx++;
                    return result;
                } else {
                    throw new NoSuchElementException("the element is not present");
                }
            }

            /**{@inheritDoc}*/
            @Override
            public void remove() {
                throw new UnsupportedOperationException("this iterator doesn't remove elements");
            }

            //Java8 an 9 only
            //@Override
            public void forEachRemaining(Consumer<? super Type> action) {
                while (hasNext())
                    action.accept(next());
            }
        };
    }

    @Override
    public Type[] toArray() {
        return Arrays.copyOfRange(internalArray,0, size);
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] ts) {
        return null;
    }

    @Override
    public boolean add(Type element) {
        if(size < CAPACITY){
            internalArray[size++] = element;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int idx = findIndex(internalArray, (Type) o);
        if(idx == -1) {
            return false;
        }
        //if it's last
        if(idx == size) {
            size--;
        }
        if(idx == 0){
           internalArray = Arrays.copyOfRange(internalArray, 1, internalArray.length);
           size--;
        } else {
            for (int i = idx+1; i < internalArray.length; i++) {
                internalArray[i-1] = internalArray[i];
            }
            size --;
        }
        return true;
    }

    private int findIndex(Type[] internalArray, Type o) {
        for (int i = 0; i < internalArray.length; i++) {
            if(internalArray[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> collection) {
        return collection.stream().allMatch(this::contains);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Type> collection) {
        return collection.stream().allMatch(this::add);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> collection) {
        return collection.stream().allMatch(this::remove);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return this.stream().filter(o -> !c.contains(o)).allMatch(this::remove);
    }

    @Override
    public void clear() {
        size = 0;
    }
}
