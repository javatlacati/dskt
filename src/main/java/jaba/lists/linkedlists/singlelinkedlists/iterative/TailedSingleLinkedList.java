package jaba.lists.linkedlists.singlelinkedlists.iterative;

import jaba.lists.MyList;
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

    @Override
    public int size() {
        Node<Type> tmp = head;
        int size=0;
        while(null != tmp){
            tmp = tmp.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public boolean contains(Type o) {
        Node<Type> current = head;
        while(current!=null){
            if(o.equals(current.getItem()))
                return true;
            current=current.getNext();
        }
        return false;
    }

    @Override
    public Type[] toArray() {
         int size = size();
        Type[] retorno = (Type[])new Object[size];
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(Type element) {
        //        System.out.println("Adding: "+element);
        return addAtEnd(new Node<>(element));
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
    }

    private boolean addAtEnd(Node<Type> aNode) {
        // check if the list is empty
        if(head == null){
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
    
    public void addAfter(Type element, Type after){
         
        Node<Type> tmp = head;
        Node<Type> refNode = null;
        /*
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                //break;
                throw new NoSuchElementException("Unable to find the given element...");
            }
//            if(tmp.compareTo(after) == 0){
            if(tmp.equals(after)){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNext();
        }
        if(refNode != null){
            //add element after the target node
            Node<Type> nd = new Node<>(element);
            nd.setNext(tmp.getNext());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNext(nd);
        } else {
            throw new NoSuchElementException("Unable to find the given element...");
        }
    }
    
    public void deleteFront(){
         
        if(null == head){
            throw new IndexOutOfBoundsException("Capacity underflow");
        }
        Node<Type> tmp = head;
        head = tmp.getNext();
        if(null == head){
            tail = null;
        }
        //System.out.println("Deleted: "+tmp.getItem());
    }
     
    public void deleteAfter(Type after){
         
        Node<Type> tmp = head;
        Node<Type> refNode = null;
        //System.out.println("Traversing to all nodes..");
        /*
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.equals(after)){//if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNext();
        }
        if(refNode != null){
            tmp = refNode.getNext();
            refNode.setNext(tmp.getNext());
            if(refNode.getNext() == null){
                tail = refNode;
            }
            //System.out.println("Deleted: "+tmp.getItem());
        } else {
            throw new NoSuchElementException("Unable to find the given element...");
        }
    }

    public String getStrings() {
        if (head== null) {
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

    @NotNull
    @Override
    public Iterator<Type> iterator() {
        return new Iterator<Type>() {
            Node<Type> tmp = head;
            @Override
            public boolean hasNext() {
                return null == tmp.getNext();
            }

            @Override
            public Type next() {
                tmp=tmp.getNext();
                return tmp.getItem();
            }
        };
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
