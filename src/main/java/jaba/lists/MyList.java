package jaba.lists;

import java.util.Collection;

/**
 * we will try to reach java.util.List features
 *
 * @param <Type> The datatype of the contained elements
 * @author Javatlacati
 */
public interface MyList<Type>  { //extends Collection<Type>

  /**
   * Gives the size of the list.
   *
   * @return number of elements
   */
  int size();

  /**
   * Determines if list is empty.
   *
   * @return <code>true</code> if the list is empty <code>false</code>
   * otherwise
   */
  boolean isEmpty();

  boolean contains(Object object);

  Type[] toArray();

  /**
   * Adds and element to the list.
   *
   * @param element the element to be added
   * @return <code>true</code> if the element was added <code>false</code>
   * otherwise
   */
  boolean add(Type element);

  boolean remove(Object o);

  /**
   * Deletes all of the elements in the list.
   */
  void clear();
}
