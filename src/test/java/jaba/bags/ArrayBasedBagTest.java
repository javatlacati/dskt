package jaba.bags;

import org.junit.Before;
import org.junit.Test;

import java.util.Spliterator;
import java.util.stream.StreamSupport;

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
    }

    @Test
    public void spliterator() throws Exception {
        arrayBasedBag.add("hola");
        arrayBasedBag.add("mundo");
        Spliterator spliterator = arrayBasedBag.spliterator();

        StreamSupport.stream(spliterator, false)
                .forEachOrdered(System.out::println);
    }

}