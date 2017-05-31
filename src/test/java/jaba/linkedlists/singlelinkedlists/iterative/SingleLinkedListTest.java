package jaba.linkedlists.singlelinkedlists.iterative;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Core i7 on 31/05/2017.
 */
public class SingleLinkedListTest {
    @Test
    public void getRoot() throws Exception {
        SingleLinkedList instance = new SingleLinkedList();
        assertNull(instance.getRoot());
    }

    @Test
    public void setRoot() throws Exception {
        SingleLinkedList instance = new SingleLinkedList();
        instance.setRoot(new Node(3));
        assertNotNull(instance.getRoot());
    }

}