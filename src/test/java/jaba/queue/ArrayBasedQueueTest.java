package jaba.queue;

import org.databene.contiperf.PerfTest;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

//import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Core i7 on 31/05/2017.
 */
//@RunWith(ParallelRunner.class)
public class ArrayBasedQueueTest {
    private static final Logger log = Logger.getLogger(ArrayBasedQueueTest.class.getName());
    private ArrayBasedQueue<Integer> queue;
    private static final int initialCapacity = 5;

//    @Rule
//    public ContiPerfRule i = new ContiPerfRule();

    @Before
    public void setUp() {
        queue = new ArrayBasedQueue<>(initialCapacity);
    }

    @Test
    @PerfTest(invocations = 1000, threads = 2)
    public void enqueue() {
        for (int i = 0; initialCapacity > i; i++) {
            queue.enqueue(i);
        }
        assertEquals("ArrayBasedQueue(queueArray=[0, 1, 2, 3, 4])", queue.toString());
        assertTrue(queue.isFull());
    }

    @Test
    @PerfTest(invocations = 1000, threads = 2)
    public void dequeue() {
        for (int i = 0; i < 3; i++) {
            queue.enqueue(i);
        }
        assertFalse(queue.isFull());
        for (int i = 0; i < 3; i++) {
            assertEquals(Integer.valueOf(i), queue.dequeue());
        }
        assertEquals("ArrayBasedQueue(queueArray=[null, null, null, null, null])", queue.toString());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void getCurrentSize() {
        assertEquals(initialCapacity, queue.getCurrentSize());
    }

    @Test
    public void isFull() {
        assertFalse(queue.isFull());
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void getCapacity() {
        assertEquals(initialCapacity, queue.getCapacity());
    }

    @Test
    public void setCapacity() {
        int newCapacity = 51;
        queue.setCapacity(newCapacity);
        assertEquals(newCapacity, queue.getCapacity());
    }

    @Test
    public void toStringTest() {
        assertEquals("ArrayBasedQueue(queueArray=[null, null, null, null, null])", queue.toString());
    }

    @Test
    public void happyPath() {
        log.info("Happy Path");
        final int expected = 1;
        queue.enqueue(expected);
        assertEquals(Integer.valueOf(expected), queue.dequeue());

        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(Integer.valueOf(2), queue.dequeue());

        queue.enqueue(5);
        queue.enqueue(6);
        log.info(queue.toString());
        assertEquals("ArrayBasedQueue(queueArray=[3, 4, 5, 6, null])", queue.toString());
    }

}