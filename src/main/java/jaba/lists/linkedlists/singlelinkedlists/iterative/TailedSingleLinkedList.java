package jaba.lists.linkedlists.singlelinkedlists.iterative;

import jaba.lists.MyList;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Javatlacati
 * @param <Type> Type of contained elements
 */
public class TailedSingleLinkedList<Type> implements MyList<Type>, Iterable<Type> {

  private Node<Type> head;
  private Node<Type> tail;

  @Override public int size() {
    Node<Type> tmp = head;
    int size = 0;
    while (null != tmp) {
      tmp = tmp.getNext();
      size++;
    }
    return size;
  }

  @Override public boolean isEmpty() {
    return head == null;
  }

  @Override public boolean contains(Object o) {
    return null != o && null != head && o.getClass().equals(head.getItem().getClass())
        && containsSameTypeVerified((Type) o);
  }

  public boolean containsSameTypeVerified(Type o) {
    Node<Type> current = head;
    while (current != null) {
      if (o.equals(current.getItem()))
        return true;
      current = current.getNext();
    }
    return false;
  }

  @Override public Type[] toArray() {
    int size = size();
    Type[] retorno = (Type[]) new Object[size];
    if (size != 0) {
      Node<Type> currentNode = head;
      int index = 0;
      while (currentNode != null) {
        retorno[index] = currentNode.getItem();
        currentNode = currentNode.getNext();
        index++;
      }
    }
    return retorno;
  }

  @NotNull public <T> T[] toArray(@NotNull T[] resultingArray) {
    int size = size();
    if (size != 0) {
      Node<T> currentNode = (Node<T>) head;
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
    //        System.out.println("Adding: "+element);
    return addAtEnd(new Node<>(element));
  }

  /**
   * {@inheritDoc}
   */
  @Override public boolean remove(Object o) {
    return null != o && null != head && o.getClass().equals(head.getItem().getClass())
        && removeChecked((Type) o);
  }

  public boolean removeChecked(Type content) {
    Node<Type> anterior = head;
    Node<Type> actual = head;

    while (actual.getItem() != content && actual.getNext() != null) {
      anterior = actual;
      actual = actual.getNext();
    }
    if (anterior.equals(actual)) {
      head = actual.getNext();
    } else {
      anterior.setNext(actual.getNext());
    }
    return true;
  }

  public boolean containsAll(@NotNull Collection<?> collection) {
    return collection.stream().allMatch(this::contains);
  }

  public boolean addAll(@NotNull Collection<? extends Type> collection) {
    return collection.stream().allMatch(this::add);
  }

  public boolean removeAll(@NotNull Collection<?> collection) {
    return collection.stream().allMatch(this::remove);
  }

  public boolean retainAll(@NotNull Collection<?> c) {
    return this.stream().filter(o -> !c.contains(o)).allMatch(this::remove);
  }

  @Override public void clear() {
    head = null;
    tail = null;
  }

  private boolean addAtEnd(Node<Type> aNode) {
    // check if the list is empty
    if (head == null) {
      //since there is only one element, both head and
      //tail points to the same object.
      head = aNode;
      tail = aNode;
    } else {
      //set current tail next link to new node
      tail.setNext(aNode);
      //set tail as newly created node
      tail = aNode;
    }
    return true;
  }

  public void addAfter(Type element, Type after) {

    Node<Type> tmp = head;
    Node<Type> refNode = null;
    /*
     * Traverse till given element
     */
    while (true) {
      if (tmp == null) {
        //break;
        throw new NoSuchElementException("Unable to find the given element...");
      }
      //            if(tmp.compareTo(after) == 0){
      if (tmp.equals(after)) {
        //found the target node, add after this node
        refNode = tmp;
        break;
      }
      tmp = tmp.getNext();
    }
    if (refNode != null) {
      //add element after the target node
      Node<Type> nd = new Node<>(element);
      nd.setNext(tmp.getNext());
      if (tmp == tail) {
        tail = nd;
      }
      tmp.setNext(nd);
    } else {
      throw new NoSuchElementException("Unable to find the given element...");
    }
  }

  public void deleteFront() {

    if (null == head) {
      throw new IndexOutOfBoundsException("Capacity underflow");
    }
    Node<Type> tmp = head;
    head = tmp.getNext();
    if (null == head) {
      tail = null;
    }
    //System.out.println("Deleted: "+tmp.getItem());
  }

  public void deleteAfter(Type after) {

    Node<Type> tmp = head;
    Node<Type> refNode = null;
    //System.out.println("Traversing to all nodes..");
    /*
     * Traverse till given element
     */
    while (true) {
      if (tmp == null) {
        break;
      }
      if (tmp.equals(after)) {//if(tmp.compareTo(after) == 0){
        //found the target node, add after this node
        refNode = tmp;
        break;
      }
      tmp = tmp.getNext();
    }
    if (refNode != null) {
      tmp = refNode.getNext();
      refNode.setNext(tmp.getNext());
      if (refNode.getNext() == null) {
        tail = refNode;
      }
      //System.out.println("Deleted: "+tmp.getItem());
    } else {
      throw new NoSuchElementException("Unable to find the given element...");
    }
  }

  public String getStrings() {
    if (head == null) {
      return "";
    } else {
      StringBuilder salida = new StringBuilder(head.toString());
      Node<Type> actual = head;
      while (actual.getNext() != null) {
        actual = actual.getNext();
        salida.append(actual.toString());
      }
      return salida.toString();
    }
  }

  public void printList() {
    System.out.println(getStrings());
  }

  @NotNull @Override public Iterator<Type> iterator() {
    return new Iterator<Type>() {
      Node<Type> tmp = head;

      @Override public boolean hasNext() {
        return null != tmp.getNext();
      }

      @Override public Type next() {
        Type aux = tmp.getItem();
        tmp = tmp.getNext();
        return aux;
      }
    };
  }

   public void reverse() {
        if (head == null) {
            // if if has no head it's empty we have finished
            return;
        } else if (head == tail) {
            // if the head is the tail we have on element and we have finished
            return;
        } else {
            tail=head;
            Node<Type> aux = head;
            head = aux.getNext();
            aux.setNext(null);
            while (head.getNext() != null) {
                Node<Type> aux1 = head.getNext();
                head.setNext(aux);
                aux = head;
                head = aux1;
            }
            head.setNext(aux);
        }
    }

    public Node<Type> getHead() {
        return this.head;
    }

    public Node<Type> getTail() {
        return this.tail;
    }

    public void setHead(Node<Type> head) {
        this.head = head;
    }

    public void setTail(Node<Type> tail) {
        this.tail = tail;
    }
}
