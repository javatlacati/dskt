package jaba.queue;

import lombok.extern.java.Log;
import org.databene.contiperf.PerfTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Core i7 on 31/05/2017.
 */
//@RunWith(ParallelRunner.class)
@Log
public class ArrayBasedQueueTest {
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
        assertEquals("ArrayBasedQueue(queueArray=[])", queue.toString());
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
    public void toStringTest() {
        assertEquals("ArrayBasedQueue(queueArray=[])", queue.toString());
    }

  @Test public void happyPath() {
    log.info("Happy Path");
    final int expected = 1;
    queue.enqueue(expected);
    assertEquals(Integer.valueOf(expected), queue.dequeue());
    queue.add(7);
    queue.enqueue(2);
    queue.add(-4);
    queue.enqueue(3);
    queue.add(4);

    assertTrue(queue.contains(2));
    assertArrayEquals(new Integer[] {7, 2, -4, 3, 4}, queue.toArray());

    assertEquals(Integer.valueOf(7), queue.remove());
    assertArrayEquals(new Integer[] {2, -4, 3, 4}, queue.toArray());
    assertEquals(Integer.valueOf(2), queue.dequeue());
    assertFalse(queue.contains(2));

    assertArrayEquals(new Integer[] {-4, 3, 4}, queue.toArray());

    queue.remove(-4);

    queue.enqueue(5);
    queue.enqueue(6);
    log.info(queue.toString());
    assertEquals("ArrayBasedQueue(queueArray=[3, 4, 5, 6])", queue.toString());
    assertArrayEquals(new Integer[] {3, 4, 5, 6}, queue.toArray());
//    assertEquals(true, queue.remove(4));
//    assertArrayEquals(new Integer[] {3, 5, 6}, queue.toArray());
  }

}
