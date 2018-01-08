package jaba.queue;

import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrador on 06/06/2017.
 */
@Log
public class AutoGrowingArrayBasedQueueTest {
    private ArrayBasedQueue queue;
    private static final int initialCapacity = 2;

    @Before
    public void setUp() throws Exception {
        queue = new AutoGrowingArrayBasedQueue(initialCapacity, 2);
    }

    @Test
    public void enqueue() throws Exception {
    }

    @Test
    public void setCapacityIncrement() throws Exception {
    }

    @Test
    public void getCapacityIncrement() throws Exception {
    }

    @Test
    public void dequeue() throws Exception {
    }

    @Test
    public void getCurrentSize() throws Exception {
    }

    @Test
    public void isFull() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void setCapacity() throws Exception {
    }

    @Test
    public void getCapacity() throws Exception {
    }

    @Test
    public void happyPath() throws Exception {
        System.out.println(queue);
        queue.enqueue(4);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(56);
        System.out.println(queue);
        queue.enqueue(2);
        System.out.println(queue);
        queue.enqueue(67);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(24);
        System.out.println(queue);
        queue.enqueue(98);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(435);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        try {
            queue.dequeue();
            System.out.println(queue);
        } catch (Exception e) {
            log.info("test dind't dequeued as expected");
        }
    }

}