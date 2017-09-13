package jaba.lists.linkedlists.singlelinkedlists.iterative;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Core i7 on 31/05/2017.
 */
public class SingleLinkedListTest {
    SingleLinkedList<String> instance;
    @Before
    public void setUp() throws Exception {
        instance = new SingleLinkedList();
    }

    @Test
    public void getStrings() throws Exception {
        instance.addAtEnd("Adios");
        instance.addAtEnd("mundo");
        instance.addAtEnd("cruel");
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
    public void getRoot() throws Exception {
        instance = new SingleLinkedList<>();
        assertNull(instance.getRoot());
    }

    @Test
    public void setRoot() throws Exception {
        instance.setRoot(new Node<>("3"));
        assertNotNull(instance.getRoot());
    }

}