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
package jaba.lists.linkedlists.singlelinkedlists;

import jaba.lists.linkedlists.singlelinkedlists.recursive.Node;
import jaba.lists.linkedlists.singlelinkedlists.recursive.SingleLinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Javatlacati
 */
public class SingleLinkedListTest {
    
    public SingleLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAtEnd method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testAddAtEnd() {
        System.out.println("addAtEnd");
        Node newNode = null;
        SingleLinkedList instance = new SingleLinkedList();
        instance.addAtEnd(newNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAtRoot method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testAddAtRoot() {
        System.out.println("addAtRoot");
        Node newNode = null;
        SingleLinkedList instance = new SingleLinkedList();
        instance.addAtRoot(newNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAtIndex method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testAddAtIndex() {
        System.out.println("addAtIndex");
        Node newNode = null;
        int index = 0;
        SingleLinkedList instance = new SingleLinkedList();
        instance.addAtIndex(newNode, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSingleLinkedListAtRoot method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testAddSingleLinkedListAtRoot() {
        System.out.println("addSingleLinkedListAtRoot");
        SingleLinkedList singleLinkedList = null;
        SingleLinkedList instance = new SingleLinkedList();
        instance.addSingleLinkedListAtRoot(singleLinkedList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSingleLinkedListAtEnd method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testAddSingleLinkedListAtEnd() {
        System.out.println("addSingleLinkedListAtEnd");
        SingleLinkedList singleLinkedList = null;
        SingleLinkedList instance = new SingleLinkedList();
        instance.addSingleLinkedListAtEnd(singleLinkedList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printList method, of class SingleLinkedList.
     */
    @Test
    public void testPrintList() {
        System.out.println("printList");
        SingleLinkedList instance = new SingleLinkedList();
        instance.addAtEnd(new Node("Adios"));
        instance.addAtEnd(new Node("mundo"));
        instance.addAtEnd(new Node("cruel"));
        instance.printList();
    }

    /**
     * Test of reverse method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testReverse() {
        System.out.println("reverse");
        SingleLinkedList instance = new SingleLinkedList();
        instance.reverse();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoot method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testSetRoot() {
        System.out.println("setRoot");
        Node root = null;
        SingleLinkedList instance = new SingleLinkedList();
        instance.setRoot(root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoot method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testGetRoot() {
        System.out.println("getRoot");
        SingleLinkedList instance = new SingleLinkedList();
        Node expResult = null;
        Node result = instance.getRoot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
