package jaba.lists;

/**
 * we will try to reach java.util.List features
 */
public interface MyList<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Object[] toArray();
    boolean add(E e);
    void clear();
}
