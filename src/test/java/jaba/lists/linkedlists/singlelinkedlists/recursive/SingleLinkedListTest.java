package jaba.lists.linkedlists.singlelinkedlists.recursive;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Core i7 on 31/05/2017.
 */
public class SingleLinkedListTest {
    SingleLinkedList instance;

    @Before
    public void setUp() throws Exception {
        instance = new SingleLinkedList();
    }

    @Test
    public void getStrings() throws Exception {
        instance.addAtEnd(new Node("Adios"));
        instance.addAtEnd(new Node("mundo"));
        instance.addAtEnd(new Node("cruel"));
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)",instance.getStrings());
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

    @Test
    public void addAtEnd() throws Exception {
    }

    @Test
    public void addAtRoot() throws Exception {
    }

    @Test
    public void addAtIndex() throws Exception {
    }

    @Test
    public void addSingleLinkedListAtRoot() throws Exception {
    }

    @Test
    public void addSingleLinkedListAtEnd() throws Exception {
    }

    @Test
    public void printList() throws Exception {
        System.out.println("printList");
        instance.addAtEnd(new Node("Adios"));
        instance.addAtEnd(new Node("mundo"));
        instance.addAtEnd(new Node("cruel"));
        instance.printList();
    }

    @Test
    public void removeLast() throws Exception {
    }

    @Test
    public void reverse() throws Exception {
        instance.addAtEnd(new Node("Adios"));
        instance.addAtEnd(new Node("mundo"));
        instance.addAtEnd(new Node("cruel"));
        SingleLinkedList instance1 = new SingleLinkedList();
        instance1.addAtEnd(new Node("cruel"));
        instance1.addAtEnd(new Node("mundo"));
        instance1.addAtEnd(new Node("Adios"));
        instance.reverse();
//        assertEquals(instance1.getStrings(), instance.getStrings());
    }

    @Test
    public void getRoot() throws Exception {
    }

    @Test
    public void setRoot() throws Exception {
    }

}