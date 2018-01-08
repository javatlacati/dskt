package jaba.bags;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BagTest {
    private Bag<Integer> bag;

    @Before
    public void setUp() {
        bag = new ArrayBasedBag<>(5);
    }

    @Test
    public void add() {
        assertThat(bag.size(), is(0));
        bag.add(10);
        assertThat(bag.size(), is(1));
    }

    @Test
    public void isEmpty() {
        assertThat(bag.isEmpty(), is(true));
        bag.add(50);
        assertThat(bag.isEmpty(), is(false));
    }

    @Test
    public void disposeItems() {
        IntStream.range(0, 5).forEachOrdered(i -> bag.add(i));
        assertThat(bag.size(), is(5));
        bag.disposeItems();
        assertThat(bag.size(), is(0));
    }
}
