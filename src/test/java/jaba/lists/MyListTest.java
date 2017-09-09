package jaba.lists;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Administrador on 10/06/2017.
 */
@RunWith(Parameterized.class)
public class MyListTest {
    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{
                        new jaba.lists.linkedlists.singlelinkedlists.iterative.SingleLinkedList()
                }, new Object[]{
                        new jaba.lists.linkedlists.singlelinkedlists.recursive.SingleLinkedList()
                }, new Object[]{
                        new jaba.lists.linkedlists.singlelinkedlists.iterative.TailedSingleLinkedList<>()
                }
        );
    }

    public MyList myList;

    public MyListTest(MyList myList) {
        this.myList = myList;
    }

    @Before
    public void setUp() throws Exception {
        myList.clear();
    }

    //tests
    @Test
    public void isEmpty() throws Exception {
        assertTrue(myList.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertNotNull(myList.size());
        assertEquals(0, myList.size());
    }


    @Test
    public void contains() throws Exception {
        assertFalse(myList.contains(null));
    }

    @Test
    public void toArray() throws Exception {
        assertArrayEquals(new Object[0], myList.toArray());
        myList.add("hola");
        Object[] arr = new Object[]{"hola"};
        assertArrayEquals(arr, myList.toArray());
        myList.add("mundo!");
        arr = new Object[]{"hola", "mundo!"};
        assertArrayEquals(arr, myList.toArray());
    }

    @Test
    public void add() throws Exception {
        assertTrue(myList.add("hola"));
        assertTrue(myList.add("mundo!"));
    }

}