package jaba.lists.linkedlists.singlelinkedlists.circular.iterative;

import jaba.lists.MyList;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

@Setter
@Getter
@EqualsAndHashCode(of = "root")
@Log
public class CircularList<Type> implements MyList<Type> {
    private Node<Type> root;

    public String getStrings() {
        if (null == root) {
            return "";
        } else {
            StringBuilder salida = new StringBuilder(root.toString());
            Node<Type> actual = root;
            while (actual.getNext() != root) {
                actual = actual.getNext();
                salida.append(actual);
            }
            return salida.toString();
        }
    }

    public void addAtEnd(Type data) {
        if (null == root) {
            root = new Node<>(data);
        } else {
            Node<Type> actual = root;
            while (actual.getNext() != root) {
                actual = actual.getNext();
            }
            actual.setNext(new Node<>(data, root));
        }
        //newNode.setNext(root);
    }

    public void addNodeAtEnd(Node<Type> newNode) {
        if (null == root) {
            root = newNode;
        } else {
            Node actual = root;
            while (actual.getNext() != root) {
                actual = actual.getNext();
            }
            actual.setNext(newNode);
        }
        newNode.setNext(root);
    }

    public void addAtRoot(Type data) {
        Node<Type> newNode = new Node<>(data, root);
        root = newNode;
    }

    public void addNodeAtRoot(Node<Type> newNode) {
        newNode.setNext(root);
        root = newNode;
    }

    /**
     * Index is 0 base
     *
     * @param data
     * @param index
     */
    public void addAtIndex(Type data, int index) {
        if (0 == index) {
            addAtRoot(data);
        } else {
            if (0 < index) {
                Node currentNode = root.getNext();
                for (int currentIndex = 1; currentIndex < index; currentIndex++) {
                    Node next = currentNode.getNext();
                    if (null == next) {
                        throw new IndexOutOfBoundsException("the specified index is not possible to reach");
                    } else {
                        currentNode = next;
                    }
                }
                currentNode.setNext(new Node(data,root));
            } else {
                throw new IndexOutOfBoundsException("no negative index values allowed");
            }
        }
    }

    public void addSingleLinkedListAtRoot(CircularList<Type> singleLinkedList) {
        singleLinkedList.addNodeAtEnd(root);
        root = singleLinkedList.getRoot();
    }

    public void addSingleLinkedListAtEnd(CircularList<Type> singleLinkedList) {
        addNodeAtRoot(singleLinkedList.getRoot());
    }

    public void printList() {
        log.info(getStrings());
    }

    public void removeLast() {
        if (null != root) {
            if (null == root.getNext()) {
                root = null;
            } else {
                Node<Type> currentNode = root;
                while (null != currentNode.getNext()) {
                    currentNode = currentNode.getNext();
                }
                if (root == currentNode.getNext()) {
                    currentNode.setNext(null);
                }
            }
        }
    }

    @Override
    public int size() {
        if(root == null){
            return 0;
        }
        Node<Type> actual = root;
        int size=1;
        while (actual.getNext() != root) {
            actual = actual.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object object) {
        return null != object && null != root && object.getClass().equals(root.getItem().getClass())
                && containsSameTypeVerified((Type) object);
    }

    private boolean containsSameTypeVerified(Type object) {
        Node<Type> actual = root;
        if (actual.getItem().equals(object)) {
            return true;
        }
        while (actual.getNext() != root) {
            actual = actual.getNext();
            if (actual.getItem().equals(object)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    @Override
    public Iterator<Type> iterator() {
        return null;
    }

    @Override
    public Type[] toArray() {
        int size = size();
        Type[] retorno = (Type[]) new Object[size];
        if (size != 0) {
            Node<Type> currentNode = root;
            int index = 0;
            do {
                retorno[index] = currentNode.getItem();
                currentNode = currentNode.getNext();
                index++;
            } while (currentNode != root);
        }
        return retorno;
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(Type element) {
        try{
            addAtEnd(element);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        return null != o
                && null != root
                && o.getClass().equals(root.getItem().getClass())
                && removeChecked((Type) o);
    }

    private boolean removeChecked(Type content) {
        Node<Type> anterior = root;
        Node<Type> actual = root;

//        while (actual.getItem() != content && actual.getNext() != root) {
//            anterior = actual;
//            actual = actual.getNext();
//        }
//        if (anterior.equals(actual)) {
//            root = actual.getNext();
//        } else {
//            anterior.setNext(actual.getNext());
//        }
        return true;
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
        root = null;
    }

    @Override
    public Type get(int index) {
        if(index == 0){
            return root.getItem();
        }
        Node<Type> actual = root;
        int currentIndex=1;
        while (actual.getNext() != root) {
            actual = actual.getNext();
            if(index == currentIndex){
                return actual.getItem();
            }
            currentIndex++;
        }
        return null;
    }
}
