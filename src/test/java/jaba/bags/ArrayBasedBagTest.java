package jaba.bags;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Administrador on 11/06/2017.
 */
public class ArrayBasedBagTest {
    ArrayBasedBag arrayBasedBag;

    @Before
    public void setUp() throws Exception {
        arrayBasedBag = new ArrayBasedBag(5);
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

    @Test
    public void iterator() throws Exception {
    }

    @Test
    public void forEach() throws Exception {
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        ArrayList<String> list = new ArrayList<>(2);
        arrayBasedBag.forEach((x) -> list.add((String) x));
        assertEquals(2, list.size());
        assertEquals(list.get(0), arrayBasedBag.getAtIndex(0));
        assertEquals(list.get(1), arrayBasedBag.getAtIndex(1));
    }

    @Test
    public void spliterator() throws Exception {
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        Spliterator<String> spliterator = arrayBasedBag.spliterator();
        ArrayList<String> list = new ArrayList<>(2);
        StreamSupport.stream(spliterator, false)
                .forEachOrdered(list::add);
        assertEquals(2, list.size());
        assertEquals(list.get(0), arrayBasedBag.getAtIndex(0));
        assertEquals(list.get(1), arrayBasedBag.getAtIndex(1));
        assertNull(arrayBasedBag.getAtIndex(3));
    }

}