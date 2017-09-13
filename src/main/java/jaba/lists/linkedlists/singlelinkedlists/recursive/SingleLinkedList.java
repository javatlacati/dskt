/*
 * Copyright 2017 Core i7.
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
package jaba.lists.linkedlists.singlelinkedlists.recursive;

import jaba.lists.MyList;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = "root")
public class SingleLinkedList<Type> implements MyList<Type> {

    private Node<Type> root;

    public boolean addAtEnd(Node<Type> newNode) {
        try {
            if (root == null) {
                root = newNode;
            } else {
                root.add(newNode);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addAtRoot(Node<Type> newNode) {
        newNode.setNext(root);
        root = newNode;
    }

    /**
     * Index is 0 based
     *
     * @param newNode
     * @param index position in the list
     */
    public void addAtIndex(Node<Type> newNode, int index) {
        if (index == 0) {
            addAtRoot(newNode);
        } else {
            if (index > 0) {
                root.addAtIndex(newNode, index, 0);
            } else {
                throw new IndexOutOfBoundsException("no negative index values allowed");
            }
        }
    }

    public void addSingleLinkedListAtRoot(SingleLinkedList<Type> singleLinkedList) {
        singleLinkedList.addAtEnd(root);
        root = singleLinkedList.getRoot();
    }

    public void addSingleLinkedListAtEnd(SingleLinkedList<Type> singleLinkedList) {
        root.add(singleLinkedList.getRoot());
    }

    public void printList() {
        System.out.println(getStrings());
    }

    public void removeLast() {
        if (root != null) {
            if (root.getNext() == null) {
                root = null;
            } else {
                root.removeLast();
            }
        }
    }

    public void reverse() {
        if (root.getNext() != null) {
            root.reverse();
        }
    }

    public String getStrings() {
        return root == null ? "" : root.getStrings();
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        } else
            return root.size(1);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Type o) {
        if (root == null && o == null) {
            return false;
        } else {
            if (root.equals(o)) {
                return true;
            } else {
                return root.getNext() != null && root.getNext().contains(o);
            }
        }
    }

    @Override
    public Type[] toArray() {
        if (root == null) {
            return (Type[]) new Object[0];
        } else {
            return root.toArray();
        }
    }

    @Override
    public boolean add(Type o) {
        return addAtEnd(new Node<>(o));
    }

    @Override
    public void clear() {
        root=null;
    }
}
