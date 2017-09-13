package jaba.bags;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

/**
 * Created by Administrador on 11/06/2017.
 */
public class ArrayBasedBagTest {
    private ArrayBasedBag<String> arrayBasedBag;

    @Before
    public void setUp() throws Exception {
        arrayBasedBag = new ArrayBasedBag<>(5);
    }

    @Test
    public void add() throws Exception {
        assertEquals(0, arrayBasedBag.size());
        arrayBasedBag.add("asd");
        assertEquals(1, arrayBasedBag.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(arrayBasedBag.isEmpty());
        arrayBasedBag.add("hola");
        assertFalse(arrayBasedBag.isEmpty());
    }

    @Test
    public void size() throws Exception {
    }

    @Test
    public void iterator() throws Exception {
        String expected="holamundo";
        StringBuilder actual= new StringBuilder();
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        for(String el:arrayBasedBag){
            actual.append(el);
        }
        assertEquals(expected, actual.toString());
    }

    @Test
    public void disposeItems() throws Exception {
        for (int i = 0; i < 5; i++) {
            arrayBasedBag.add(Integer.toString(i));
        }
        assertEquals(5, arrayBasedBag.size());
        arrayBasedBag.disposeItems();
        assertEquals(0, arrayBasedBag.size());
    }

    @Test
    public void forEach() throws Exception {
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        ArrayList<String> list = new ArrayList<>(2);
        arrayBasedBag.forEach(list::add);
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