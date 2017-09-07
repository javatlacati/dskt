package jaba.bags;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {
    Bag<Integer> bag;

    @Before
    public void setUp() throws Exception {
        bag = new ArrayBasedBag<>(5);
    }

    @Test
    public void add() throws Exception {
        assertEquals(0, bag.size());
        bag.add(10);
        assertEquals(1, bag.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(bag.isEmpty());
        bag.add(50);
        assertFalse(bag.isEmpty());
    }

    @Test
    public void disposeItems() throws Exception {
        for (int i = 0; i < 5; i++) {
            bag.add(i);
        }
        assertEquals(5, bag.size());
        bag.disposeItems();
        assertEquals(0, bag.size());
    }
}
