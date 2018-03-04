package jaba.lists.linkedlists.singlelinkedlists.iterative;

import jaba.lists.MyList;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = "root")
public class SingleLinkedList<Type> implements MyList<Type> {
    private Node<Type> root;

    public String getStrings() {
        if (root == null) {
            return "";
        } else {
            StringBuilder salida = new StringBuilder(root.toString());
            Node<Type> actual = root;
            while (actual.getNext() != null) {
                actual = actual.getNext();
                salida.append(actual.toString());
            }
            return salida.toString();
        }
    }

    /***/
    public boolean addAtEnd(Type element) {
        Node<Type> newNode = new Node<>(element);
        try {
            if (root == null) {
                root = newNode;
            } else {
                Node<Type> actual = root;
                while (actual.getNext() != null) {
                    actual = actual.getNext();
                }
                actual.setNext(newNode);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /***/
    public void addAtRoot(Type element) {
        Node<Type> newNode = new Node<>(element);
        newNode.setNext(root);
        root = newNode;
    }

    /**
     * Index is 0 base
     *
     * @param element
     * @param index   position to insert
     */
    public void addAtIndex(Type element, int index) {
        if (index == 0) {
            addAtRoot(element);
        } else {
            if (index > 0) {
                Node<Type> currentNode = root.getNext();
                for (int currentIndex = 1; currentIndex < index; currentIndex++) {
                    Node<Type> next = currentNode.getNext();
                    if (next != null) {
                        currentNode = next;
                    } else {
                        throw new IndexOutOfBoundsException("the specified index is not possible to reach");
                    }
                }
                currentNode.setNext(new Node<>(element));
            } else {
                throw new IndexOutOfBoundsException("no negative index values allowed");
            }
        }
    }

    public void addSingleLinkedListAtRoot(SingleLinkedList<Type> singleLinkedList) {
        singleLinkedList.addAtEnd(root.getItem());
        root = singleLinkedList.getRoot();
    }

    public void addSingleLinkedListAtEnd(SingleLinkedList<Type> singleLinkedList) {
        addAtRoot(singleLinkedList.getRoot().getItem());
    }

    public void printList() {
        System.out.println(getStrings());
    }

    public void removeLast() {
        if (root != null) {
            if (root.getNext() == null) {
                root = null;
            } else {
                Node<Type> currentNode = root;
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                if (currentNode.getNext() == null) {
                    currentNode.setNext(null);
                }
            }
        }
    }

    @Override
    public int size() {
        int size = 0;
        Node<Type> currentNode = root;
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

//    @Override
//    public boolean contains(Object o){
//        return o instanceof Class<Type> ? containsSameTypeVerified(o): false;
//    }

    public boolean contains(Type o) { //SameTypeVerified
        if (root == null && o == null) {
            return false;
        } else {
            Node<Type> currentNode = root;
            while (currentNode != null) {
                if (currentNode.equals(o))
                    return true;
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    @Override
    public Type[] toArray() {
        int size = size();
        Type[] resultingArray = (Type[]) new Object[size];
        if (size != 0) {
            Node<Type> currentNode = root;
            int index = 0;
            while (currentNode != null) {
                resultingArray[index] = currentNode.getItem();
                currentNode = currentNode.getNext();
                index++;
            }
        }
        return resultingArray;
    }

    @Override
    public boolean add(Type o) {
        return addAtEnd(o);
    }

    @Override
    public void clear() {
        root = null;
    }
}
