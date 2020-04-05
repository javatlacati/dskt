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
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

public class SingleLinkedList<Type> implements MyList<Type> {

    private Node<Type> root;

    public boolean addAtEnd(Type element) {
        Node<Type> newNode = new Node<>(element);
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

    public void addAtRoot(Type element) {
        Node<Type> newNode = new Node<>(element);
        newNode.setNext(root);
        root = newNode;
    }

    /**
     * Index is 0 based
     *
     * @param element
     * @param index   position in the list
     */
    public void addAtIndex(Type element, int index) {
        if (index == 0) {
            addAtRoot(element);
        } else {
            if (index > 0) {
                root.addAtIndex(element, index, 0);
            } else {
                throw new IndexOutOfBoundsException("no negative index values allowed");
            }
        }
    }

    public void addSingleLinkedListAtRoot(SingleLinkedList<Type> singleLinkedList) {
        if (singleLinkedList == null || singleLinkedList.getRoot() == null)
            return;
        if (root != null)
            if (singleLinkedList.addAtEnd(root.getItem()))
                root = singleLinkedList.getRoot();
            else
                System.err.println("can't be addeded");
        else
            System.err.println("root es nulo");
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
        if (root != null) {
            if (root.getNext() != null) {
                root = root.reverse(null, root);
            }
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
    public boolean contains(Object o) {
        return null != o && null != root && o.getClass().equals(root.getItem().getClass()) && root
                .contains((Type) o);
    }

    @NotNull
    @Override
    public Iterator<Type> iterator() {
        return new Iterator<Type>() {
            Node<Type> tmp = root;

            @Override
            public boolean hasNext() {
                return null != tmp.getNext();
            }

            @Override
            public Type next() {
                Type aux = tmp.getItem();
                tmp = tmp.getNext();
                return aux;
            }
        };
    }

    @Override
    public boolean remove(Object o) {
        if (null != o && null != root && o.getClass().equals(root.getItem().getClass()))
            if (o.equals(root.getItem())) {
                root = root.getNext();
                return true;
            } else {
                return root.remove((Type) o, root, root.getNext());
            }

        return false;
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
    public Type[] toArray() {
        if (root == null) {
            return (Type[]) new Object[0];
        } else {
            return root.toArray();
        }
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(Type o) {
        return addAtEnd(o);
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Type get(int index) {
//        if (index == 0) {
            return root.get(index);
//        } else {
//            return root.get(index-1);
//        }
    }

    public Node<Type> getRoot() {
        return this.root;
    }

    public void setRoot(Node<Type> root) {
        this.root = root;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SingleLinkedList))
            return false;
        final SingleLinkedList other = (SingleLinkedList) o;
        if (!other.canEqual((Object) this))
            return false;
        final Object this$root = this.getRoot();
        final Object other$root = other.getRoot();
        return (null == this$root) ? (null == other$root) : this$root.equals(other$root);
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $root = this.getRoot();
        result = result * PRIME + ($root == null ? 43 : $root.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof SingleLinkedList;
    }
}
