package jaba.bags;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrador on 11/06/2017.
 */
public class ArrayBasedBagTest {
    private ArrayBasedBag<String> arrayBasedBag;

    @Before
    public void setUp() {
        arrayBasedBag = new ArrayBasedBag<>(5);
    }

    @Test
    public void add() {
        assertThat(arrayBasedBag.size(), is(0));
        arrayBasedBag.add("asd");
        assertThat(arrayBasedBag.size(), is(1));
    }

    @Test
    public void isEmpty() {
        assertThat(arrayBasedBag.isEmpty(), is(true));
        arrayBasedBag.add("hola");
        assertThat(arrayBasedBag.isEmpty(), is(false));
    }

    @Test
    public void size() {
    }

    @Test
    public void iterator() {
        final String expected = "holamundo";
        final StringBuilder actual = new StringBuilder(8);
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        for (String el : arrayBasedBag) {
            actual.append(el);
        }
        assertThat(actual.toString(), is(expected));
    }

    @Test
    public void disposeItems() {
        IntStream.range(0, 5).forEachOrdered(i -> arrayBasedBag.add(Integer.toString(i)));
        assertThat(arrayBasedBag.size(), is(5));
        arrayBasedBag.disposeItems();
        assertThat(arrayBasedBag.size(), is(0));
    }

    @Test
    public void forEach() {
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        final ArrayList<String> list = new ArrayList<>(2);
        arrayBasedBag.forEach(list::add);
        assertThat(list.size(), is(2));
        assertThat(arrayBasedBag.getAtIndex(0), is(list.get(0)));
        assertThat(arrayBasedBag.getAtIndex(1), is(list.get(1)));
    }

    @Test
    public void spliterator() {
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        final Spliterator<String> spliterator = arrayBasedBag.spliterator();
        final ArrayList<String> list = new ArrayList<>(2);
        StreamSupport.stream(spliterator, false)
                .forEachOrdered(list::add);
        assertThat(list.size(), is(2));
        assertThat(arrayBasedBag.getAtIndex(0), is(list.get(0)));
        assertThat(arrayBasedBag.getAtIndex(1), is(list.get(1)));
        assertThat(arrayBasedBag.getAtIndex(3), nullValue());
    }

}