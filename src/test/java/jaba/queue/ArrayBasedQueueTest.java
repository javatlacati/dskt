package jaba.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Core i7 on 31/05/2017.
 */
public class ArrayBasedQueueTest {
    ArrayBasedQueue queue;
    private static final int initialCapacity = 5;

    @Before
    public void setUp() throws Exception {
        queue = new ArrayBasedQueue(initialCapacity);
    }

    @Test
    public void enqueue() throws Exception {
        for (int i = 0; i < initialCapacity; i++) {
            queue.enqueue(i);
        }
        assertEquals("ArrayBasedQueue(queueArray=[0, 1, 2, 3, 4])", queue.toString());
        assertTrue(queue.isFull());
    }

    @Test
    public void dequeue() throws Exception {
        for (int i = 0; i < 3; i++) {
            queue.enqueue(i);
        }
        assertFalse(queue.isFull());
        for (int i = 0; i < 3; i++) {
            assertEquals((2 - i), queue.dequeue());
        }
        assertEquals("ArrayBasedQueue(queueArray=[null, null, null, null, null])", queue.toString());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void getCurrentSize() throws Exception {
        assertEquals(initialCapacity, queue.getCurrentSize());
    }

    @Test
    public void isFull() throws Exception {
        assertFalse(queue.isFull());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void getCapacity() throws Exception {
        assertEquals(initialCapacity, queue.getCapacity());
    }

    @Test
    public void setCapacity() throws Exception {
        int newCapacity = 51;
        queue.setCapacity(newCapacity);
        assertEquals(newCapacity, queue.getCapacity());
    }

    @Test
    public void toStringTest() throws Exception {
        assertEquals("ArrayBasedQueue(queueArray=[null, null, null, null, null])", queue.toString());
    }

}