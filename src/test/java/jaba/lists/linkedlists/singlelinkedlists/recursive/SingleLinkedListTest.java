package jaba.lists.linkedlists.singlelinkedlists.recursive;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Core i7 on 31/05/2017.
 */
public class SingleLinkedListTest {
    private SingleLinkedList<String> instance;

    @Before
    public void setUp() throws Exception {
        instance = new SingleLinkedList<>();
    }

    @Test
    public void equalstest() throws Exception {
    }

    @Test
    public void hashCodetest() throws Exception {
    }

    @Test
    public void canEqual() throws Exception {
    }

    /**
     * Test of addAtEnd method, of class SingleLinkedList.
     */
    @Test
    public void testAddAtEnd() {
        instance.addAtRoot("mundo");
        instance.addAtRoot("Adios");
        instance.addAtEnd("cruel");
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)", instance.getStrings());
    }

    /**
     * Test of addAtRoot method, of class SingleLinkedList.
     */
    @Test
    public void testAddAtRoot() {
        System.out.println("addAtRoot");
        instance.addAtRoot("cruel");
        instance.addAtRoot("mundo");
        instance.addAtRoot("Adios");
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)", instance.getStrings());
    }

    /**
     * Test of addAtIndex method, of class SingleLinkedList.
     */
    @Test
    public void testAddAtIndex() {
        System.out.println("addAtIndex");
        instance.addAtRoot("cruel");
        instance.addAtRoot("Adios");
        int index = 1;
        instance.addAtIndex("mundo", index);
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)", instance.getStrings());
    }

    /**
     * Test of addSingleLinkedListAtRoot method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testAddSingleLinkedListAtRoot() {
        System.out.println("addSingleLinkedListAtRoot");
        SingleLinkedList instance1 = new SingleLinkedList();
        instance1.add(4);
        instance.addSingleLinkedListAtRoot(instance1);
        instance.printList();
        SingleLinkedList<String> instance2 = new SingleLinkedList<>();
        instance2.add("hola");
        instance.addSingleLinkedListAtRoot(instance2);
        System.out.println("list 2");
        instance.printList();
    }

    /**
     * Test of addSingleLinkedListAtEnd method, of class SingleLinkedList.
     */
    @Test
    @Ignore
    public void testAddSingleLinkedListAtEnd() {
        System.out.println("addSingleLinkedListAtEnd");
        SingleLinkedList singleLinkedList = null;
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
        instance.addAtEnd("Adios");
        instance.addAtEnd("mundo");
        instance.addAtEnd("cruel");
        instance.printList();
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)", instance.getStrings());
    }

    @Test
    public void removeLast() throws Exception {
        instance.addAtEnd("Adios");
        instance.addAtEnd("mundo");
        instance.addAtEnd("cruel");
        instance.addAtEnd("perro");
        instance.removeLast();
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)", instance.getStrings());
    }

    @Test
    @Ignore
    public void reverse() throws Exception {
        String strings = instance.getStrings();
        instance.reverse();
        assertEquals(strings, instance.getStrings());

        instance.addAtEnd("Adios");
        strings = instance.getStrings();
        instance.reverse();
        assertEquals(strings, instance.getStrings());

        instance.addAtEnd("mundo");
        instance.addAtEnd("cruel");
        SingleLinkedList<String> instance1 = new SingleLinkedList<>();
        instance1.addAtEnd("cruel");
        instance1.addAtEnd("mundo");
        instance1.addAtEnd("Adios");
        instance.reverse();
        assertEquals(instance1.getStrings(), instance.getStrings());
    }

    /**
     * Test of getRoot method, of class SingleLinkedList.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        Node result = instance.getRoot();
        assertEquals(null, result);
        Node<String> expResult = new Node<>("Hola");
        instance.add("Hola");
        assertEquals(expResult, instance.getRoot());
    }

    /**
     * Test of setRoot method, of class SingleLinkedList.
     */
    @Test
    public void testSetRoot() {
        System.out.println("setRoot");
        instance.add("Adios");
        assertEquals("Node(item=Adios)", instance.getStrings());
        Node root = null;
        instance.setRoot(root);
        assertEquals("", instance.getStrings());
        instance.setRoot(new Node<>("hola"));
        assertEquals("Node(item=hola)", instance.getStrings());
    }

    @Test
    public void getStrings() throws Exception {
        instance.add("Adios");
        instance.add("mundo");
        instance.add("cruel");
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)", instance.getStrings());
    }

}
