package jaba.queue;

/**
 * The time needed to add or delete an item is constant and independent of the number of items in the queue. So both addition and deletion can be O(1) operation.
 */
public class ArrayBasedQueue<Item> {
    /**
     * numbe of elements that the queue can hold.
     */
    protected int capacity;
    /**
     * Internal array to hold the data.
     */
    Item[] queueArray;

    private int Index = 0;

    public ArrayBasedQueue(int queueSize) {
        capacity = queueSize;
        queueArray = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return 0 == Index;
    }

    public boolean isFull() {
        return Index == capacity;
    }

    public synchronized void enqueue(Item item) {
        if (isFull()) {
            throw new OutOfMemoryError("Queue Capacity has been excedeed");
        } else {
            queueArray[Index] = item;
            Index++;
        }
    }

    public synchronized Item dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue Undeflow");
        } else {
            final Item dequeued = queueArray[0];
            final int length = queueArray.length - 1;
            for (int i = 0; i < length; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            Index--;
            return dequeued;
        }
    }

    public int getCurrentSize() {
        return capacity - Index;
    }

    public void makeEmpty() {
        Index = 0;
    }

    public String toString() {
        return "ArrayBasedQueue(queueArray=" + java.util.Arrays.deepToString(queueArray) + ")";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
