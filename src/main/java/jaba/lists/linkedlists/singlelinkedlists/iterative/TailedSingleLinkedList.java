/*
 * Copyright 2017 Ruslan López Carro.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jaba.lists.linkedlists.singlelinkedlists.iterative;

import jaba.lists.MyList;
import java.util.NoSuchElementException;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Javatlacati
 * @param <Type> Type of contained elements
 */
@Setter
@Getter
public class TailedSingleLinkedList<Type> implements MyList<Type> {

    private Node<Type> head;
    private Node<Type> tail;

    @Override
    public int size() {
        Node<Type> tmp = head;
        int size=0;
        while(true){
            if(tmp == null){
                break;
            }
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
        /**
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
         
        if(head == null){
            //System.out.println("Underflow...");
        }
        Node<Type> tmp = head;
        head = tmp.getNext();
        if(head == null){
            tail = null;
        }
        //System.out.println("Deleted: "+tmp.getItem());
    }
     
    public void deleteAfter(Type after){
         
        Node<Type> tmp = head;
        Node<Type> refNode = null;
        //System.out.println("Traversing to all nodes..");
        /**
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

}
