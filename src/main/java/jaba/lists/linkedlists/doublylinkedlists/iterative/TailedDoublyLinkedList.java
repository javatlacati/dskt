package jaba.lists.linkedlists.doublylinkedlists.iterative;

import jaba.lists.MyList;
import lombok.experimental.var;
import org.jetbrains.annotations.NotNull;

/**
 * @author Core i7
 */
public class TailedDoublyLinkedList<Type> implements MyList<Type> {

  Node<Type> head;
  Node<Type> tail;

  public TailedDoublyLinkedList() {
  }

  /**
   * {@inheritDoc}
   */
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * {@inheritDoc}
   */
  @Override public void clear() {
    head = null;
    tail = null;
  }

  /**
   * {@inheritDoc}
   */
  public Type[] toArray() {
    int size = size();
    Type[] resultingArray = (Type[]) new Object[size];
    if (size != 0) {
      Node<Type> currentNode = head;
      int index = 0;
      while (currentNode != null) {
        resultingArray[index] = currentNode.getItem();
        currentNode = currentNode.getNext();
        index++;
      }
    }
    return resultingArray;
  }

  /**
   * {@inheritDoc}
   */
  @Override public boolean add(Type element) {
    return addAtEnd(element);
  }

  public boolean addAtStart(Type element) {
    Node<Type> temporal = new Node<>(element);
    if (isEmpty()) {
      head = temporal;
      tail = temporal;
    } else {
      temporal.setNext(head);
      temporal.setPrevious(temporal);
      head = temporal;
    }
    return true;
  }

  public boolean addAtEnd(Type element) {
    Node<Type> temporal = new Node<>(element);
    if (isEmpty()) {
      head = temporal;
      tail = temporal;

    } else {
      tail.setNext(temporal);
      temporal.setPrevious(tail);
      tail = temporal;
    }
    return true;
  }

  /**
   * Gives the size of the list.
   *
   * @return number of elements
   */
  @Override public int size() {
    Node<Type> tmp = head;
    int size = 0;
    while (null != tmp) {
      tmp = tmp.getNext();
      size++;
    }
    return size;
  }

  @Override public boolean contains(Type object) {
    Node<Type> current = head;
    while(current!=null){
      if(object.equals(current.getItem()))
        return true;
      current=current.getNext();
    }
    return false;
  }

  public void removeFirst() {
    Node<Type> temporal = head;
    head = head.getNext();
    temporal.setPrevious(null);
  }

  public void removeLast() {
    if (tail.getPrevious() == null) {
      head = null;
      tail = null;
    } else {
      tail = tail.getPrevious();
      tail.setNext(null);
    }
  }

//  public String toString() {
//    StringBuilder dato = new StringBuilder();
//    Node axu = head;
//
//    while (axu != null) {
//      dato.append("{ ").append(axu.toString()).append(" }").append("\n");
//      axu = axu.getNext();
//    }
//    return dato.toString();
//  }

//  @Override
//  public String toString() {
//    StringBuilder dato = new StringBuilder();
//    Node axu = tail;
//
//    while (axu != null) {
//      dato.append("{ ").append(axu.toString()).append(" }");
//      axu = axu.getPrevious();
//    }
//    return dato.toString();
//  }

  public void remove(int pos) {
    Node<Type> prev = head;
    Node<Type> current = head;

    int k = 0;

    if (pos > 0) {
      while (k != pos && current.getNext() != null) {
        prev = current;
        current = current.getNext();
        k++;
        System.out.println(" k " + k);
      }
      prev.setNext(current.getNext());
    }
  }

  public void deleteFirstByContent(Type content) {
    Node<Type> anterior = head;
    Node<Type> actual = head;

    while (actual.getItem() != content && actual.getNext() != null) {
      anterior = actual;
      actual = actual.getNext();
    }
    anterior.setNext(actual.getNext());
  }

}
