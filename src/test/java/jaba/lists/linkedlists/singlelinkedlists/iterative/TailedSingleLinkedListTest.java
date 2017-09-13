package jaba.lists.linkedlists.singlelinkedlists.iterative;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TailedSingleLinkedListTest {
    TailedSingleLinkedList<String> instance;
    @Before
    public void setUp() throws Exception {
        instance = new TailedSingleLinkedList<>();
    }

    @Test
    public void setRoot() throws Exception {
        instance.setHead(new Node<>("hola"));
        assertNotNull(instance.getHead());
    }

    @Test
    public void getStrings() throws Exception {
        instance.add("Adios");
        instance.add("mundo");
        instance.add("cruel");
        assertEquals("Node(item=Adios)Node(item=mundo)Node(item=cruel)",instance.getStrings());
    }

}