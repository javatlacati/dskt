package jaba.bags;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BagTest {
    Bag<Integer> bag;

    @Before
    public void setUp() throws Exception {
        bag = new ArrayBasedBag<>(5);
    }

    @Test
    public void add() throws Exception {
        Assert.assertEquals(0, bag.size());
        bag.add(10);
        Assert.assertEquals(1, bag.size());
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(true, bag.isEmpty());
        bag.add(50);
        Assert.assertEquals(false, bag.isEmpty());
    }

    @Test
    public void disposeItems() throws Exception {
        for (int i = 0; i < 5; i++) {
            bag.add(i);
        }
        Assert.assertEquals(5, bag.size());
        bag.disposeItems();
        Assert.assertEquals(0, bag.size());
    }
}
