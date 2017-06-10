package jaba.lists;

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
                }
        );
    }

    public MyList myInterface;

    public MyListTest(MyList myInterface) {
        this.myInterface = myInterface;
    }


    //tests
    @Test
    public void isEmpty() throws Exception {
        assertTrue(myInterface.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertNotNull(myInterface.size());
        assertEquals(0, myInterface.size());
    }

    @Test
    public void contains() throws Exception {
        assertFalse(myInterface.contains(null));
    }

}