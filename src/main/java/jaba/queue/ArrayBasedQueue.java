package jaba.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.val;

/**
 * The time needed to add or delete an item is constant and independent of the number of items in the queue. So both addition and deletion can be O(1) operation.
 */
@ToString(of = "queueArray")
public class ArrayBasedQueue {
    @Getter
    @Setter
    private int capacity;
    private Object queueArray[];
    private int topIndex = 0;

    public ArrayBasedQueue(int queueSize) {
        this.capacity = queueSize;
        queueArray = new Object[this.capacity];
    }

    public synchronized void enqueue(Object item) {
        if (isFull()) {
            throw new OutOfMemoryError("Queue Capacity has been excedeed");
        } else {
            queueArray[topIndex++] = item;
        }

    }

    public synchronized Object dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue Undeflow");
        } else {
            val dequeued = queueArray[topIndex-1];
            queueArray[topIndex-1] = null;
            topIndex--;
            return dequeued;
        }
    }

    public int getCurrentSize() {
        return capacity - topIndex;
    }

    public boolean isFull() {
        return capacity < (topIndex + 1);
    }

    public boolean isEmpty() {
        return topIndex == 0;
    }
}
