package jaba.linkedlists.singlelinkedlists.recursive;

import lombok.val;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        val instance1 = new SingleLinkedList();
        instance1.addAtEnd(new Node("cruel"));
        instance.addAtEnd(new Node("mundo"));
        instance.addAtEnd(new Node("Adios"));
        instance.reverse();
        assertEquals(instance1, instance);
    }

    @Test
    public void getRoot() throws Exception {
    }

    @Test
    public void setRoot() throws Exception {
    }

}