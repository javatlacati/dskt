package jaba.linkedlists.singlelinkedlists.recursive;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Core i7 on 31/05/2017.
 */
public class SingleLinkedListTest {
    @Before
    public void setUp() throws Exception {
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
        SingleLinkedList instance = new SingleLinkedList();
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
    }

    @Test
    public void getRoot() throws Exception {
    }

    @Test
    public void setRoot() throws Exception {
    }

}