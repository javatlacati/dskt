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
package jaba.lists.linkedlists.singlelinkedlists.circular.recursive;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(of = "root")
public class SingleLinkedList {

    private jaba.lists.linkedlists.singlelinkedlists.recursive.Node root;

    public void addAtEnd(jaba.lists.linkedlists.singlelinkedlists.recursive.Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
//            root.add(newNode);
        }
    }

    public void addAtRoot(jaba.lists.linkedlists.singlelinkedlists.recursive.Node newNode) {
        newNode.setNext(root);
        root = newNode;
    }

    /**
     * Index is 0 base
     *
     * @param newNode
     * @param index
     */
    public void addAtIndex(Node newNode, int index) {
//        if (index == 0) {
//            addAtRoot(newNode);
//        } else {
//            if (index > 0) {
//                root.addAtIndex(newNode, index, 0);
//            } else {
//                throw new IndexOutOfBoundsException("no negative index values allowed");
//            }
//        }
    }

    public void addSingleLinkedListAtRoot(SingleLinkedList singleLinkedList) {
        singleLinkedList.addAtEnd(root);
        root = singleLinkedList.getRoot();
    }

    public void addSingleLinkedListAtEnd(SingleLinkedList singleLinkedList) {
//        root.add(singleLinkedList.getRoot());
    }

    public void printList() {
        System.out.println(getStrings());
    }

    public void removeLast() {
//        if (root != null) {
//            if (root.getNext() == null) {
//                root = null;
//            } else {
//                root.removeLast();
//            }
//        }
    }

    public void reverse() {
//        if (root.getNext() != null) {
//            root.reverse();
//        }
    }

    public String getStrings() {
        return null == root ? "" : "";//root.getStrings();
    }
}
